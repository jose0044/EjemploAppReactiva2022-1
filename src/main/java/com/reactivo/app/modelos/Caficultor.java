package com.reactivo.app.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Caficultor {

    protected String cedula;
    protected String nombreCompleto;
    protected String ciudadResidencia;
    protected ArrayList<Cafe> cafesProducidos;
    protected List<Saco> sacosCaficultor;

    public Caficultor(String cedula, String nombreCompleto, String ciudadResidencia, ArrayList<Cafe> cafesProducidos) {

        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.ciudadResidencia = ciudadResidencia;
        this.cafesProducidos = cafesProducidos;
    }

    public Caficultor(String cedula, String nombreCompleto, String ciudadResidencia, List<Saco> sacosCaficultor) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.ciudadResidencia = ciudadResidencia;
        this.sacosCaficultor = sacosCaficultor;
    }
}
