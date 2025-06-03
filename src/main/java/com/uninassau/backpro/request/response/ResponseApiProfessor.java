package com.uninassau.backpro.request.response;

import com.uninassau.backpro.model.dto.ProfessorDTO;

import java.util.List;

public record ResponseApiProfessor(List<ProfessorDTO> professores, String mensagem) {
}
