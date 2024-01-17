package fr.carbon.textile.score.api.mapper;


public interface DTOEntityMapper<D, E> {
    D toDTO(E entity);

    E toEntity(D dto);
}
