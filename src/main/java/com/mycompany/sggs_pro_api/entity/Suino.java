package com.mycompany.sggs_pro_api.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import jakarta.persistence.*;

@Entity
@Table(name = "suinos")
public class Suino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)

    @NotNull(message = "O número é obrigatório.")
    @Positive(message = "O número deve ser maior que zero.")
    private Integer numero;

    @NotNull(message = "O peso é obrigatório.")
    @Positive(message = "O peso deve ser maior que zero.")
    private Double peso;

    @NotNull(message = "A idade é obrigatória.")
    @Positive(message = "A idade deve ser maior que zero.")
    private Integer idade;

    @NotBlank(message = "A raça é obrigatória.")
    private String raca;

    @NotBlank(message = "A finalidade é obrigatória.")
    private String finalidade;

    public Suino() {
    }

    public Suino(Long id,
                 Integer numero,
                 Double peso,
                 Integer idade,
                 String raca,
                 String finalidade) {

        this.id = id;
        this.numero = numero;
        this.peso = peso;
        this.idade = idade;
        this.raca = raca;
        this.finalidade = finalidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }
}