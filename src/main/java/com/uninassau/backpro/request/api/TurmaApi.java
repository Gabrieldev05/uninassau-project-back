package com.uninassau.backpro.request.api;

import com.uninassau.backpro.exceptions.MensagemErrorException;
import com.uninassau.backpro.model.dto.TurmaDTO;
import com.uninassau.backpro.request.response.ResponseApiTurma;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turma")
@Tag(name = "Informações das Turmas")
@OpenAPIDefinition
public interface TurmaApi {

    @Operation(summary = "Buscar Turmas", description = "Endpoint responsável por obter Turmas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso ao encontrar as turmas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseApiTurma.class))}),
            @ApiResponse(responseCode = "404", description = "Turmas não encontradas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErrorException.class))}),
            @ApiResponse(responseCode = "500", description = "Internal system error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErrorException.class)))})
    @GetMapping(value = "/buscar")
    ResponseEntity<ResponseApiTurma> buscarTurmas();

    @Operation(summary = "Criar Turma", description = "Endpoint responsável por criar Turma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso ao criar a Turma",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseApiTurma.class))}),
            @ApiResponse(responseCode = "404", description = "Turma não cadastrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErrorException.class))}),
            @ApiResponse(responseCode = "500", description = "Internal system error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErrorException.class)))})
    @GetMapping(value = "/salvar")
    ResponseEntity<ResponseApiTurma> salvarTurma(TurmaDTO turma);
}
