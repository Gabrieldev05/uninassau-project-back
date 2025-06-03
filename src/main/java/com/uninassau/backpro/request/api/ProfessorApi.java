package com.uninassau.backpro.request.api;

import com.uninassau.backpro.exceptions.MensagemErrorException;
import com.uninassau.backpro.model.dto.ProfessorDTO;
import com.uninassau.backpro.request.response.ResponseApiProfessor;
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
@RequestMapping("/professor")
@Tag(name = "Informações dos Professores")
@OpenAPIDefinition
public interface ProfessorApi {

    @Operation(summary = "Buscar professores", description = "Endpoint responsável por obter professores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso ao encontrar os professores",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseApiProfessor.class))}),
            @ApiResponse(responseCode = "404", description = "Professores não encontrados",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErrorException.class))}),
            @ApiResponse(responseCode = "500", description = "Internal system error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErrorException.class)))})
    @GetMapping(value = "/buscar")
    ResponseEntity<ResponseApiProfessor> buscarProfessor();

    @Operation(summary = "Criar professor", description = "Endpoint responsável por criar Professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso criar professor",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseApiProfessor.class))}),
            @ApiResponse(responseCode = "404", description = "Professores não cadastrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErrorException.class))}),
            @ApiResponse(responseCode = "500", description = "Internal system error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MensagemErrorException.class)))})
    @GetMapping(value = "/salvar")
    ResponseEntity<ResponseApiProfessor> salvarProfessor(@RequestBody ProfessorDTO professor);
}
