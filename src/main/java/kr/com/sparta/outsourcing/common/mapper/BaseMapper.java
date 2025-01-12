package kr.com.sparta.outsourcing.common.mapper;

import org.modelmapper.ModelMapper;

public abstract class BaseMapper<E, D> {
    private final ModelMapper modelMapper;
    private final Class<E> entityClass;
    private final Class<D> domainClass;

    protected BaseMapper(ModelMapper mm, Class<E> eClass, Class<D> dClass) {
        this.modelMapper = mm;
        this.entityClass = eClass;
        this.domainClass = dClass;
    }

    public D toDomain(E entity) {
        return (entity == null) ? null : modelMapper.map(entity, domainClass);
    }

    public E toEntity(D domain) {
        return (domain == null) ? null : modelMapper.map(domain, entityClass);
    }
}
