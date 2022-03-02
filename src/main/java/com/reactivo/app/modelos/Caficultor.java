package com.reactivo.app.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Caficultor {

    protected String cedula;
    protected String nombreCompleto;
    protected String ciudadResidencia;
    protected ArrayList<Cafe> cafesProducidos;
    protected Map<Integer, Saco> sacos;
}
