package com.prologg.logbook.mapper;

import java.util.List;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig(componentModel = "spring")
public interface MapperBase<E, D> {

	E merge(D dto, @MappingTarget E entity);

	D entityToDto(E entity);

	default List<D> entityToDto(List<E> lstEntity) {
		return lstEntity.stream().map(this::entityToDto).toList();
	}

	E dtoToEntity(D dto);

	default List<E> dtoToEntity(List<D> lstDto) {
		return lstDto.stream().map(this::dtoToEntity).toList();
	}

}
