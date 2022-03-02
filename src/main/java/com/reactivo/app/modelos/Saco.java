package com.reactivo.app.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Saco {
    private Integer numero;
    private Cafe tipoCafe;
    private Double peso;
    private String material;
    private String fechaEmpaque;
}
