package com.reactivo.app.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Saco {

    protected int id;
    protected Cafe cafe;
    protected float peso;
    protected String material;
    protected String fecha;
}
