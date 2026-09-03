package com.mycompany.sggs_pro_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "vacinacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento: Muitas vacinas para 1 Suíno
    @ManyToOne
    @JoinColumn(name = "suino_id", nullable = false)
    private Suino suino;

    @NotBlank(message = "O nome da vacina é obrigatório.")
    private String nomeVacina;

    @NotNull(message = "A data da vacinação é obrigatória.")
    private LocalDate dataAplicacao;

    @NotBlank(message = "A dose é obrigatória (ex: 1ª Dose, Reforço).")
    private String dose;
}