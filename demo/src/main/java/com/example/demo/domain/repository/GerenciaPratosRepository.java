package com.example.demo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.model.GerenciaPratos;
import com.example.demo.domain.model.Usuario;




public interface GerenciaPratosRepository extends JpaRepository<GerenciaPratos, Long>{
    
    List<GerenciaPratos> findByUsuario(Usuario usuario);
}
