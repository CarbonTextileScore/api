package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.exception.CustomException;
import fr.carbon.textile.score.api.mapper.user.information.UserMapper;
import fr.carbon.textile.score.api.repository.user.information.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository _userRepository;

    private final UserMapper _userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        super();
        _userRepository = userRepository;
        _userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getUsers() {
        return _userRepository.findAll().stream().map(_userMapper::toDTO).toList();
    }

    @Override
    public UserDTO getUserIdentity(Integer id, UserDTO userDTO) throws CustomException {
        if (Objects.equals(userDTO.getId(), id)) {
            return _userRepository.getUserIdentity(id);
        }
        throw new CustomException("You are not allowed to access this resource");
    }
}
