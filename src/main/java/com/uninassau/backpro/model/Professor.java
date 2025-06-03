package com.uninassau.backpro.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "professor")
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "idade")
    private int idade;

    @Column(name = "disciplina")
    private String disciplina;

    @OneToMany(mappedBy = "professor")
    private List<RlcTurmaProfessor> turmas;

    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;

    @Column(name = "is_concursado")
    private boolean concursado;

}
