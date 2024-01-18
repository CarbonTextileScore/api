package fr.carbon.textile.score.api.mapper.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.InvoiceEntity;
import fr.carbon.textile.score.api.dto.user.information.InvoiceDTO;
import fr.carbon.textile.score.api.mapper.DTOEntityMapper;
import fr.carbon.textile.score.api.mapper.market.information.ProductTypeMapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class InvoiceMapper implements DTOEntityMapper<InvoiceDTO, InvoiceEntity> {
    private final ProductTypeMapper _productTypeMapper;
    private final UserMapper _userMapper;

    public InvoiceMapper(ProductTypeMapper productTypeMapper, UserMapper userMapper) {
        _productTypeMapper = productTypeMapper;
        _userMapper = userMapper;
    }

    @Override
    public InvoiceDTO toDTO(InvoiceEntity entity) {
        return InvoiceDTO.builder()
                .id(entity.getId())
                .quota(entity.getQuota())
                .date(entity.getDate())
                .productType(_productTypeMapper.toDTO(entity.getProductType()))
                .user(_userMapper.toDTO(entity.getUser()))
                .productPrice(entity.getProductPrice())
                .build();
    }

    @Override
    public InvoiceEntity toEntity(InvoiceDTO dto) {
        InvoiceEntity entity = new InvoiceEntity(
                new Timestamp(dto.getDate().getTime()),
                dto.getQuota(),
                _userMapper.toEntity(dto.getUser()),
                _productTypeMapper.toEntity(dto.getProductType()),
                dto.getProductPrice()
        );
        entity.setId(dto.getId());
        return entity;
    }
}
