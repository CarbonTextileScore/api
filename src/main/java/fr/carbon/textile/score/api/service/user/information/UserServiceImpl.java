package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.UserEntity;
import fr.carbon.textile.score.api.dto.user.information.InvoiceDTO;
import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.exception.CustomException;
import fr.carbon.textile.score.api.mapper.user.information.UserMapper;
import fr.carbon.textile.score.api.repository.user.information.UserRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository _userRepository;

    private final UserMapper _userMapper;

    private final InvoiceService _invoiceService;

    private final CityService _cityService;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, InvoiceService invoiceService, CityService cityService) {
        super();
        _userRepository = userRepository;
        _userMapper = userMapper;
        _invoiceService = invoiceService;
        _cityService = cityService;
    }

    @Override
    public List<UserDTO> getUsers() {
        return _userRepository.findAll().stream().map(_userMapper::toDTO).toList();
    }

    @Override
    public UserDTO getUserIdentity(UserDTO userEntity) {
        return _userRepository.getUserIdentity(userEntity.getId());
    }

    @Override
    public UserDTO getQuotaPersonal(UserDTO userEntity) throws CustomException {
            UserEntity user = getUserEntity(userEntity.getId());
            return _userMapper.toQuotaPersonal(user);
    }

    @Override
    public UserDTO getDashboard(UserDTO userDTO) throws CustomException {
        UserEntity userEntity = getUserEntity(userDTO.getId());
        List<InvoiceDTO> personalInvoices = _invoiceService.getQuarterlyInvoices(userEntity.getId());
        Double personalQuota = Math.round(personalInvoices.stream().mapToDouble(InvoiceDTO::getQuota).sum() / 450.0 * 1000.0) / 10.0;
        List<UserDTO> familyMembers = getFamilyMembers(userEntity);
        return UserDTO.builder()
                .name(userEntity.getName())
                .lastname(userEntity.getLastname())
                .gender(userEntity.getGender().equals("M") ? "Homme" : "Femme")
                .birthdate(new SimpleDateFormat("dd/MM/yyyy").format(userEntity.getBirthdate()))
                .age(Period.between(userEntity.getBirthdate().toLocalDateTime().toLocalDate(), LocalDate.now()).getYears())
                .personalQuota(personalQuota)
                .invoices(personalInvoices)
                .city(_cityService.getCityQuota(userEntity.getCity().getId()))
                .familyMembers(familyMembers)
                .familyQuota(Math.round((familyMembers.stream().mapToDouble(UserDTO::getPersonalQuota).sum() + personalQuota) / (familyMembers.size() + 1) * 10.0) / 10.0)
                .build();
    }

    private UserEntity getUserEntity(Integer id) throws CustomException {
        return _userRepository.findById(id).orElseThrow(() -> new CustomException("User not found"));
    }

    private List<UserDTO> getFamilyMembers(UserEntity userEntity) {
        List<UserDTO> family = new ArrayList<>();

        userEntity.getFamily().getUsers().stream().filter(u -> u.getId() != userEntity.getId()).forEach(u -> {
            try {
                family.add(UserDTO.builder()
                                .name(u.getName())
                                .birthdate(new SimpleDateFormat("dd/MM/yyyy").format(u.getBirthdate()))
                                .gender(u.getGender().equals("M") ? "Homme" : "Femme")
                                .personalQuota(Math.round(_invoiceService.getQuarterlyInvoices(u.getId()).stream().mapToDouble(InvoiceDTO::getQuota).sum() / 450.0 * 1000.0) / 10.0)
                                .age(Period.between(u.getBirthdate().toLocalDateTime().toLocalDate(), LocalDate.now()).getYears())
                        .build());
            } catch (CustomException ignored) {}
        });

        return family;
    }
}
