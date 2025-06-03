package com.uninassau.backpro.request.api;

import com.uninassau.backpro.exceptions.MensagemErrorException;
import com.uninassau.backpro.model.dto.AlunoDTO;
import com.uninassau.backpro.request.response.ResponseApiAluno;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
@Tag(name = "Informações dos Alunos")
@OpenAPIDefinition
public interface AlunoApi {

    @Operation(summary = "Buscar Alunos", description = "Endpoint responsável por obter Alunos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso ao encontrar os alunos",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseApiAluno.class))}),
            @ApiResponse(responseCode = "404", description = "Alunos não encontrados",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErrorException.class))}),
            @ApiResponse(responseCode = "500", description = "Internal system error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErrorException.class)))})
    @GetMapping(value = "/buscar")
    ResponseEntity<ResponseApiAluno> buscarAluno();

    @Operation(summary = "Criar Aluno", description = "Endpoint responsável por criar Aluno")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso ao criar aluno",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseApiAluno.class))}),
            @ApiResponse(responseCode = "404", description = "Aluno não cadastrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErrorException.class))}),
            @ApiResponse(responseCode = "500", description = "Internal system error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErrorException.class)))})
    @PostMapping(value = "/salvar")
    ResponseEntity<ResponseApiAluno> salvarAluno(@RequestBody AlunoDTO aluno);
}
