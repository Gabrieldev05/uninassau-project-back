package com.uninassau.backpro.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "aluno")
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "idade")
    private int idade;

    @Column(name = "data_matricula")
    private LocalDate dataMatricula;

    @Column(name = "is_bolsista")
    private boolean bolsista;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;
}
