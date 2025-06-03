package com.uninassau.backpro.model.mapper;

import com.uninassau.backpro.model.Professor;
import com.uninassau.backpro.model.dto.ProfessorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    ProfessorDTO toDTO(Professor professor);
    Professor toEntity(ProfessorDTO professorDTO);
}