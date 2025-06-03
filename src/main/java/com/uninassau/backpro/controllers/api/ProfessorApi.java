package com.uninassau.backpro.controllers.api;

import com.uninassau.backpro.model.Professor;
import com.uninassau.backpro.model.Professor;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@Tag(name = "Informaçoes do Professor")
@OpenAPIDefinition
public interface ProfessorApi {

    @Operation(summary = "Buscar professor", description = "Endpoint responsável por obter informacoes do professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso ao encontrar os professores",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Exception.class))}),
            @ApiResponse(responseCode = "404", description = "Professores não encontrados",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Exception.class))}),
            @ApiResponse(responseCode = "500", description = "Internal system error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Exception.class)))})
    @GetMapping(value = "/buscar")
    ResponseEntity<List<Professor>> buscarProfessor();

    @Operation(summary = "Salvar professor", description = "Endpoint responsável por salvar Professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso ao encontrar os professores",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Exception.class))}),
            @ApiResponse(responseCode = "404", description = "Professores não encontrados",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Exception.class))}),
            @ApiResponse(responseCode = "500", description = "Internal system error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Exception.class)))})
    @GetMapping(value = "/salvar")
    ResponseEntity salvarProfessor(@RequestBody Professor professor);
}
