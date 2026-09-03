package com.mycompany.sggs_pro_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "suinos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}