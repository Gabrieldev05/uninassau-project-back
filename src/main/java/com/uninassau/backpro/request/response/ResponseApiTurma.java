package com.uninassau.backpro.request.response;

import com.uninassau.backpro.model.dto.TurmaDTO;

import java.util.List;

public record ResponseApiTurma(List<TurmaDTO> turmas, String mensagem) {
}
