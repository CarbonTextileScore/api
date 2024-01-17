package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.UserEntity;
import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.mapper.user.information.UserMapper;
import fr.carbon.textile.score.api.repository.user.information.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository _userRepository;

    private UserMapper _userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        super();
        _userRepository = userRepository;
        _userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getUsers() {
        return _userRepository.findAll().stream().map(_userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserIdentity(Integer id, UserEntity userEntity) {
        if (userEntity.getId() == id) {
            return _userRepository.getUserIdentity(id);
        } else {
            throw new RuntimeException("You are not allowed to access this resource");
        }
    }
}