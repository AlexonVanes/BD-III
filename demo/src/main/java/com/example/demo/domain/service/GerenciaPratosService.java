package com.example.demo.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.dto.GerenciaPratosRequestDTO;
import com.example.demo.domain.dto.GerenciaPratosResponseDTO;
import com.example.demo.domain.exception.ResourceNotFoundException;
import com.example.demo.domain.model.GerenciaPratos;
import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.repository.GerenciaPratosRepository;



@Service
public class GerenciaPratosService implements ICRUDService<GerenciaPratosRequestDTO, GerenciaPratosResponseDTO>{
    @Autowired
    private GerenciaPratosRepository GerenciaPratosRespository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<GerenciaPratosResponseDTO> obterTodos() {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("Teste" + usuario);
        List<GerenciaPratos> GerenciaPratoss = GerenciaPratosRespository.findByUsuario(usuario);
        return GerenciaPratoss.stream()
        .map(GerenciaPratos -> mapper.map(GerenciaPratos, GerenciaPratosResponseDTO.class))
        .collect(Collectors.toList());

    }

    @Override
    public GerenciaPratosResponseDTO obterPorId(Long id) {
        Optional<GerenciaPratos> optGerenciaPratos = GerenciaPratosRespository.findById(id);
        if(optGerenciaPratos.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível encontrar o título com o id: " + id);
        }
        return mapper.map(optGerenciaPratos.get(), GerenciaPratosResponseDTO.class);
    }

    @Override
    public GerenciaPratosResponseDTO cadastrar(GerenciaPratosRequestDTO dto) {
        GerenciaPratos GerenciaPratos = mapper.map(dto,GerenciaPratos.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        GerenciaPratos.setUsuario(usuario);
        GerenciaPratos.setId(null);

        GerenciaPratos = GerenciaPratosRespository.save(GerenciaPratos);
        return mapper.map(GerenciaPratos, GerenciaPratosResponseDTO.class);
    }

    @Override
    public GerenciaPratosResponseDTO atualizar(Long id, GerenciaPratosRequestDTO dto) {
        obterPorId(id);
        GerenciaPratos GerenciaPratos = mapper.map(dto, GerenciaPratos.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        GerenciaPratos.setUsuario(usuario);
        GerenciaPratos.setId(id);
        GerenciaPratos = GerenciaPratosRespository.save(GerenciaPratos);
        return mapper.map(GerenciaPratos, GerenciaPratosResponseDTO.class);
    }

    @Override
    public void deletar(Long id) {
        obterPorId(id);
        GerenciaPratosRespository.deleteById(id);
    }

}
