package com.uninassau.backpro.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "turma")
@Entity
public class Turma {

    @Id
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ano")
    private String ano;

    @Column(name = "periodo")
    private String periodo;

    @ManyToOne
    @JoinColumn(name = "id")
    private Professor professor;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aluno> alunos;
}
