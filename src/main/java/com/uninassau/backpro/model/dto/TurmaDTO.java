package com.uninassau.backpro.model.dto;

import com.uninassau.backpro.model.Professor;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TurmaDTO {

    private Long turmaId;
    private String nome;
    private String ano;
    private String periodo;
    private Professor professor;
    private List<AlunoDTO> alunos;
}
