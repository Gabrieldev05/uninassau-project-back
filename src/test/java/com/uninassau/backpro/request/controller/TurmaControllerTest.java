package com.uninassau.backpro.request.controller;

import com.uninassau.backpro.model.Turma;
import com.uninassau.backpro.model.dto.TurmaDTO;
import com.uninassau.backpro.model.mapper.TurmaMapper;
import com.uninassau.backpro.request.response.ResponseApiTurma;
import com.uninassau.backpro.services.TurmaService;
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

class TurmaControllerTest {

    @InjectMocks
    private TurmaController turmaController;

    @Mock
    private TurmaService turmaService;

    @Mock
    private TurmaMapper turmaMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRetornarListaDeTurmasQuandoExistirem() {
        // Arrange
        Turma turma = Turma.builder().id(1L).nome("Turma A").build();
        TurmaDTO turmaDTO = TurmaDTO.builder().id(1L).nome("Turma A").build();
        when(turmaService.buscarTurmas()).thenReturn(List.of(turma));
        when(turmaMapper.toDTO(turma)).thenReturn(turmaDTO);

        // Act
        ResponseEntity<ResponseApiTurma> response = turmaController.buscarTurmas();

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Turmas encontradas com Sucesso!", response.getBody().mensagem());
        assertEquals(1, response.getBody().turmas().size());
        assertEquals("Turma A", response.getBody().turmas().get(0).getNome());
    }

    @Test
    void deveRetornarMensagemQuandoNaoExistiremTurmas() {
        // Arrange
        when(turmaService.buscarTurmas()).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<ResponseApiTurma> response = turmaController.buscarTurmas();

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Nenhuma turma encontrada!", response.getBody().mensagem());
        assertNull(response.getBody().turmas());
    }

    @Test
    void deveSalvarTurmaComSucesso() {
        // Arrange
        TurmaDTO turmaDTO = TurmaDTO.builder().nome("Turma B").nome("Descrição B").build();
        Turma turma = Turma.builder().nome("Turma B").nome("Descrição B").build();
        when(turmaMapper.toEntity(turmaDTO)).thenReturn(turma);

        // Act
        ResponseEntity<ResponseApiTurma> response = turmaController.salvarTurma(turmaDTO);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Turma salva com sucesso!", response.getBody().mensagem());
        verify(turmaService, times(1)).salvarTurma(turma);
    }

    @Test
    void deveVincularAlunosATurmaComSucesso() {
        // Arrange
        List<Long> guidAlunos = List.of(1L, 2L, 3L);
        Long turmaId = 1L;

        // Act
        ResponseEntity<ResponseApiTurma> response = turmaController.vincularAlunoATurma(guidAlunos, turmaId);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Alunos vinculados com sucesso!", response.getBody().mensagem());
        verify(turmaService, times(1)).vincularAlunosAturma(guidAlunos, turmaId);
    }
}