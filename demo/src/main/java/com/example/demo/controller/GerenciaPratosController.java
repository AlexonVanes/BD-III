package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.dto.GerenciaPratosRequestDTO;
import com.example.demo.domain.dto.GerenciaPratosResponseDTO;
import com.example.demo.domain.service.GerenciaPratosService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/GerenciaPratoss")
public class GerenciaPratosController {
    @Autowired
    private GerenciaPratosService GerenciaPratosService;

    @GetMapping
    public ResponseEntity<List<GerenciaPratosResponseDTO>> obterTodos(){
        return ResponseEntity.ok(GerenciaPratosService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GerenciaPratosResponseDTO> obterPorId(@PathVariable Long id){
        return ResponseEntity.ok(GerenciaPratosService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<GerenciaPratosResponseDTO> cadastrar(@RequestBody GerenciaPratosRequestDTO dto){
        GerenciaPratosResponseDTO responseDTO = GerenciaPratosService.cadastrar(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GerenciaPratosResponseDTO> atualizar(@PathVariable Long id, @RequestBody GerenciaPratosRequestDTO dto){
        GerenciaPratosResponseDTO responseDTO = GerenciaPratosService.atualizar(id, dto);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        GerenciaPratosService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
