package fr.carbon.textile.score.api.security.jwt;

import fr.carbon.textile.score.api.security.user.details.UserDetailsServiceImplementation;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils _jwtUtils;
    @Autowired
    private UserDetailsServiceImplementation _userDetailsService;
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationTokenFilter.class);

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            String jwt = _jwtUtils.parseJwt(request);
            if (jwt == null || _jwtUtils.isJwtTokenNotValidated(jwt)) {
                filterChain.doFilter(request, response);
                LOGGER.error("Cannot set user authentication -> jwt == null or unvalidated");
                return;
            }
            String username = _jwtUtils.getUsernameFromJwtToken(jwt);
            UserDetails userDetails = _userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            LOGGER.error("Cannot set user authentication: ", e);
        }
        filterChain.doFilter(request, response);
    }


}
