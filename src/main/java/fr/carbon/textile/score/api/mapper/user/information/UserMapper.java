package fr.carbon.textile.score.api.mapper.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.InvoiceEntity;
import fr.carbon.textile.score.api.database.entity.user.information.UserEntity;
import fr.carbon.textile.score.api.dto.user.information.InvoiceDTO;
import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.mapper.DTOEntitiesMapperWrapper;
import fr.carbon.textile.score.api.mapper.DTOEntityMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements DTOEntityMapper<UserDTO, UserEntity> {
    private final InvoiceMapper _invoiceMapper;

    public UserMapper(@Lazy InvoiceMapper invoiceMapper) {
        _invoiceMapper = invoiceMapper;
    }

    @Override
    public UserDTO toDTO(UserEntity entity) {
        DTOEntitiesMapperWrapper<InvoiceDTO, InvoiceEntity> wrapper = new DTOEntitiesMapperWrapper<>(_invoiceMapper);
        return UserDTO.builder()
                .name(entity.getName())
                .lastname(entity.getLastname())
                .invoices(wrapper.toDTOs(entity.getInvoices()))
                .id(entity.getId())
                .build();
    }

    @Override
    public UserEntity toEntity(UserDTO dto) {
        UserEntity entity = new UserEntity(
                dto.getName(),
                dto.getLastname(),
                null,
                null,
                dto.getGender(),
                null,
                dto.getPicture(),
                null,
                null,
                null
        );
        entity.setId(dto.getId());
        return entity;
    }

    public UserDTO toQuotaPersonal(UserEntity user) {
        return UserDTO.builder()
                .personalQuota(
                        (double) user.getInvoices().stream().mapToInt(InvoiceEntity::getQuota).sum() / (double) user.getQuota().getMaxQuotaQuarterly())
                .build();
    }
}
