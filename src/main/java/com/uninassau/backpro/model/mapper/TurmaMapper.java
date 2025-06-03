package com.uninassau.backpro.model.mapper;

import com.uninassau.backpro.model.Turma;
import com.uninassau.backpro.model.dto.TurmaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TurmaMapper {
    TurmaMapper INSTANCE = Mappers.getMapper(TurmaMapper.class);

    TurmaDTO toDTO(Turma turma);
    Turma toEntity(TurmaDTO turmaDTO);
}
