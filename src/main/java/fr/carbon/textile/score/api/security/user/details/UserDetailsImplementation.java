package fr.carbon.textile.score.api.security.user.details;

import fr.carbon.textile.score.api.database.entity.user.information.AuthorityEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UserDetailsImplementation implements UserDetails {
    private final String _username;
    private final String _password;
    private final Collection<? extends GrantedAuthority> _authorities;

    public UserDetailsImplementation(
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities
    ) {
        _username = username;
        _password = password;
        _authorities = authorities;
    }

    public static UserDetailsImplementation build(AuthorityEntity authority) {
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(
                authority.getRole().getName()
                )
        );

        return new UserDetailsImplementation(
                authority.getUsername(), authority.getPassword(), authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return _authorities;
    }

    @Override
    public String getPassword() {
        return _password;
    }

    @Override
    public String getUsername() {
        return _username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsImplementation that = (UserDetailsImplementation) o;
        return Objects.equals(_username, that._username) &&
                Objects.equals(_password, that._password) &&
                Objects.equals(_authorities, that._authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_username, _password, _authorities);
    }
}
