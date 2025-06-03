package com.uninassau.backpro.request.controller;

import com.uninassau.backpro.exceptions.MensagemErrorException;
import com.uninassau.backpro.model.Aluno;
import com.uninassau.backpro.model.dto.AlunoDTO;
import com.uninassau.backpro.model.mapper.AlunoMapper;
import com.uninassau.backpro.request.response.ResponseApiAluno;
import com.uninassau.backpro.services.AlunoService;
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

class AlunoControllerTest {

    @InjectMocks
    private AlunoController alunoController;

    @Mock
    private AlunoService alunoService;

    @Mock
    private AlunoMapper alunoMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRetornarListaDeAlunosQuandoExistirem() {
        // Arrange
        Aluno aluno = Aluno.builder().id(1L).nome("João").build();
        AlunoDTO alunoDTO = AlunoDTO.builder().id(1L).nome("João").build();
        when(alunoService.buscarAlunos()).thenReturn(List.of(aluno));
        when(alunoMapper.toDTO(aluno)).thenReturn(alunoDTO);

        // Act
        ResponseEntity<ResponseApiAluno> response = alunoController.buscarAluno();

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Alunos encontrados com sucesso!", response.getBody().mensagem());
        assertEquals(1, response.getBody().alunos().size());
        assertEquals("João", response.getBody().alunos().get(0).getNome());
    }

    @Test
    void deveRetornarMensagemQuandoNaoExistiremAlunos() {
        // Arrange
        when(alunoService.buscarAlunos()).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<ResponseApiAluno> response = alunoController.buscarAluno();

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Nenhum aluno encontrado!", response.getBody().mensagem());
        assertNull(response.getBody().alunos());
    }

    @Test
    void deveSalvarAlunoComSucesso() {
        // Arrange
        AlunoDTO alunoDTO = AlunoDTO.builder().nome("Maria").build();
        Aluno aluno = Aluno.builder().nome("Maria").build();
        when(alunoMapper.toEntity(alunoDTO)).thenReturn(aluno);

        // Act
        ResponseEntity<ResponseApiAluno> response = alunoController.salvarAluno(alunoDTO);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Aluno salvo com sucesso!", response.getBody().mensagem());
        verify(alunoService, times(1)).salvarAluno(aluno);
    }

    @Test
    void deveLancarExcecaoAoSalvarAluno() {
        // Arrange
        AlunoDTO alunoDTO = AlunoDTO.builder().nome("Maria").build();
        Aluno aluno = Aluno.builder().nome("Maria").build();
        when(alunoMapper.toEntity(alunoDTO)).thenReturn(aluno);
        doThrow(new RuntimeException("Erro ao salvar aluno")).when(alunoService).salvarAluno(aluno);

        // Act & Assert
        MensagemErrorException exception = assertThrows(MensagemErrorException.class, () -> alunoController.salvarAluno(alunoDTO));
        assertEquals("Erro ao salvar aluno", exception.getMessage());
    }
}