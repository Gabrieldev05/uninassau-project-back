package com.uninassau.backpro.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "professor")
@Entity
public class Professor {

    @Id
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "idade")
    private int idade;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turma> turmas;

    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;

    @Column(name = "is_concursado")
    private boolean concursado;

}
