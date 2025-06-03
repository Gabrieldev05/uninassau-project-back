package com.uninassau.backpro.model.mapper;

import com.uninassau.backpro.model.Turma;
import com.uninassau.backpro.model.dto.TurmaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TurmaMapper {
    TurmaDTO toDTO(Turma turma);
    Turma toEntity(TurmaDTO turmaDTO);
}
