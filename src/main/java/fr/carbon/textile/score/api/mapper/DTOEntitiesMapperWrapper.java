package fr.carbon.textile.score.api.mapper;

import java.util.ArrayList;
import java.util.List;

public class DTOEntitiesMapperWrapper<D, E> implements DTOEntityMapper<D, E> {
    private final DTOEntityMapper<D, E> _mapper;

    public DTOEntitiesMapperWrapper(DTOEntityMapper<D, E> mapper) {
        _mapper = mapper;
    }

    public List<D> toDTOs(List<E> entities) {
        ArrayList<D> list = new ArrayList<>();
        for (E entity : entities) {
            list.add(toDTO(entity));
        }
        return list;
    }

    public List<E> toEntities(List<D> DTOs) {
        ArrayList<E> list = new ArrayList<>();
        for (D DTO : DTOs) {
            list.add(toEntity(DTO));
        }
        return list;
    }

    @Override
    public D toDTO(E entity) {
        return _mapper.toDTO(entity);
    }

    @Override
    public E toEntity(D dto) {
        return _mapper.toEntity(dto);
    }
}
