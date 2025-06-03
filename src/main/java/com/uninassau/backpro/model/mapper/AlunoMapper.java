package com.uninassau.backpro.model.mapper;

import com.uninassau.backpro.model.Aluno;
import com.uninassau.backpro.model.dto.AlunoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AlunoMapper {
    AlunoDTO toDTO(Aluno aluno);
    Aluno toEntity(AlunoDTO alunoDTO);
}