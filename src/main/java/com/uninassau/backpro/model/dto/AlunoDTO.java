package com.uninassau.backpro.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoDTO {

    private Long id;
    private String nome;
    private String sexo;
    private int idade;
    private LocalDate dataMatricula;
    private boolean bolsista;
}