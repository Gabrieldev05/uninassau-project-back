package com.uninassau.backpro.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TurmaDTO {

    private Long id;
    private String nome;
    private String ano;
    private String periodo;
}
