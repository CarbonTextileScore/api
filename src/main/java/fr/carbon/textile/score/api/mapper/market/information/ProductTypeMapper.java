package fr.carbon.textile.score.api.mapper.market.information;

import fr.carbon.textile.score.api.database.entity.market.information.ProductTypeEntity;
import fr.carbon.textile.score.api.dto.market.information.ProductTypeDTO;
import fr.carbon.textile.score.api.mapper.DTOEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeMapper implements DTOEntityMapper<ProductTypeDTO, ProductTypeEntity> {
    @Override
    public ProductTypeDTO toDTO(ProductTypeEntity entity) {
        return ProductTypeDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public ProductTypeEntity toEntity(ProductTypeDTO dto) {
        ProductTypeEntity entity = new ProductTypeEntity(dto.getName());
        entity.setId(dto.getId());
        return entity;
    }
}
