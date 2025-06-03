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
    private Long turmaId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ano")
    private String ano;

    @Column(name = "periodo")
    private String periodo;

    @ManyToOne
    @JoinColumn(name = "id")
    private Professor professor;

    @OneToMany(mappedBy = "alunoId")
    private List<Aluno> alunos;

    @Version
    private Integer version;
}
