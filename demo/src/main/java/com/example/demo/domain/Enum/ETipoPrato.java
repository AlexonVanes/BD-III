package com.example.demo.domain.Enum;

public enum ETipoPrato {
    QUENTE("Prato Quente!"),
    FRIO("Pratos frios e saladas!");

    private String valor;

    private ETipoPrato(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return this.valor;
    }   
}
