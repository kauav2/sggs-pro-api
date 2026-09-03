package com.mycompany.sggs_pro_api.dto;

import lombok.Data;

@Data
public class SuinoResponseDTO {
    private Long id;
    private Integer numero;
    private Double peso;
    private Integer idade;
    private String raca;
    private String finalidade;
}