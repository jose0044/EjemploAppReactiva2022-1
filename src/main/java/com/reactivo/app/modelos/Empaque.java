package com.reactivo.app.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empaque {

    protected String nombre;
    protected String tipo;
    protected Float peso;
    protected Float costo; //En USD
    protected Integer capacidad; //En gramos
}
