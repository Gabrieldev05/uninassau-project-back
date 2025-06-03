package com.uninassau.backpro.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorDTO {

    private Long id;
    private String nome;
    private String sexo;
    private int idade;
    private String disciplina;
    private LocalDate dataAdmissao;
    private boolean concursado;
}
