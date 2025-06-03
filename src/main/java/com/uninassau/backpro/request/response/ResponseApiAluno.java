package com.uninassau.backpro.request.response;

import com.uninassau.backpro.model.dto.AlunoDTO;

import java.util.List;

public record ResponseApiAluno(List<AlunoDTO> alunos, String mensagem) {

}
