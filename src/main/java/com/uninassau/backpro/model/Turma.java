package com.uninassau.backpro.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "turma")
@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ano")
    private String ano;

    @Column(name = "periodo")
    private String periodo;

    @OneToMany(mappedBy = "turma")
    private List<RlcTurmaProfessor> professores;

    @OneToMany(mappedBy = "turma")
    private List<RlcTurmaAluno> alunos;

}