package com.example.demo.domain.dto;
import com.example.demo.domain.Enum.ETipoPrato;


public class GerenciaPratosRequestDTO {
    private Long id;
    private String nome;
    private String descricao;
    private ETipoPrato tipo;
    private Double precoCusto;
    private Double precoVenda;
    private Integer tempoPreparo;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public ETipoPrato getTipo() {
        return tipo;
    }
    public void setTipo(ETipoPrato tipo) {
        this.tipo = tipo;
    }
    public Double getPrecoCusto() {
        return precoCusto;
    }
    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }
    public Double getPrecoVenda() {
        return precoVenda;
    }
    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }
    public Integer getTempoPreparo() {
        return tempoPreparo;
    }
    public void setTempoPreparo(Integer tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }
    
    
    
    
}
