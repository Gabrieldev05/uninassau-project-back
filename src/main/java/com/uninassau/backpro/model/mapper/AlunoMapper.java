package com.uninassau.backpro.model.mapper;

import com.uninassau.backpro.model.Aluno;
import com.uninassau.backpro.model.dto.AlunoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    AlunoDTO toDTO(Aluno aluno);
    Aluno toEntity(AlunoDTO alunoDTO);
}