package fr.carbon.textile.score.api.mapper.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.InvoiceEntity;
import fr.carbon.textile.score.api.database.entity.user.information.UserEntity;
import fr.carbon.textile.score.api.dto.quota.information.QuotaDTO;
import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.mapper.DTOEntityMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public class UserMapper implements DTOEntityMapper<UserDTO, UserEntity> {
    @Override
    public UserDTO toDTO(UserEntity entity) {
        return UserDTO.builder()
                .name(entity.getName())
                .lastname(entity.getLastname())
                .build();
    }

    @Override
    public UserEntity toEntity(UserDTO dto) {
        return null;
    }

    public UserDTO toQuotaPersonal(UserEntity user) {
//        int month = LocalDate.now().getMonth();
//        switch ()
//        Timestamp.valueOf(
//        List<InvoiceEntity> invoices = user.getInvoices().stream().filter(invoice -> invoice.getDate().after(new Date(LocalDate.now().minusMonths(3L)))).toList();
        return UserDTO.builder()
                .personalQuota(
                        (double) user.getInvoices().stream().mapToInt(InvoiceEntity::getQuota).sum() / (double) user.getQuota().getMaxQuotaQuarterly())
                .build();
    }
}
