package com.uninassau.backpro.model.mapper;

import com.uninassau.backpro.model.Professor;
import com.uninassau.backpro.model.dto.ProfessorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProfessorMapper {

    ProfessorDTO toDTO(Professor professor);

    Professor toEntity(ProfessorDTO professorDTO);
}