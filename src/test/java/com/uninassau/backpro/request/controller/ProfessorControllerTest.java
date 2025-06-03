package com.uninassau.backpro.request.controller;

import com.uninassau.backpro.model.Professor;
import com.uninassau.backpro.model.dto.ProfessorDTO;
import com.uninassau.backpro.model.mapper.ProfessorMapper;
import com.uninassau.backpro.request.response.ResponseApiProfessor;
import com.uninassau.backpro.services.ProfessorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProfessorControllerTest {

    @InjectMocks
    private ProfessorController professorController;

    @Mock
    private ProfessorService professorService;

    @Mock
    private ProfessorMapper professorMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRetornarListaDeProfessoresQuandoExistirem() {
        // Arrange
        Professor professor = Professor.builder().id(1L).nome("Carlos").build();
        ProfessorDTO professorDTO = ProfessorDTO.builder().id(1L).nome("Carlos").build();
        when(professorService.bucarProfessores()).thenReturn(List.of(professor));
        when(professorMapper.toDTO(professor)).thenReturn(professorDTO);

        // Act
        ResponseEntity<ResponseApiProfessor> response = professorController.buscarProfessor();

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Professor encontrado com Sucesso!", response.getBody().mensagem());
        assertEquals(1, response.getBody().professores().size());
        assertEquals("Carlos", response.getBody().professores().get(0).getNome());
    }

    @Test
    void deveRetornarMensagemQuandoNaoExistiremProfessores() {
        // Arrange
        when(professorService.bucarProfessores()).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<ResponseApiProfessor> response = professorController.buscarProfessor();

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Nenhum professor encontrado!", response.getBody().mensagem());
        assertNull(response.getBody().professores());
    }

    @Test
    void deveSalvarProfessorComSucesso() {
        // Arrange
        ProfessorDTO professorDTO = ProfessorDTO.builder().nome("Ana").build();
        Professor professor = Professor.builder().nome("Ana").build();
        when(professorMapper.toEntity(professorDTO)).thenReturn(professor);

        // Act
        ResponseEntity<ResponseApiProfessor> response = professorController.salvarProfessor(professorDTO);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Professor salvo com sucesso!", response.getBody().mensagem());
        verify(professorService, times(1)).salvarProfessor(professor);
    }

    @Test
    void deveLancarExcecaoAoSalvarProfessor() {
        // Arrange
        ProfessorDTO professorDTO = ProfessorDTO.builder().nome("Ana").build();
        Professor professor = Professor.builder().nome("Ana").build();
        when(professorMapper.toEntity(professorDTO)).thenReturn(professor);
        doThrow(new RuntimeException("Erro ao salvar professor")).when(professorService).salvarProfessor(professor);

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> professorController.salvarProfessor(professorDTO));
        assertEquals("Erro ao salvar professor", exception.getMessage());
    }
}