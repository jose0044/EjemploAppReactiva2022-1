package com.reactivo.app.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cafe {

    protected String serial;
    protected String variedad;
    protected Integer alturaCultivo;
    protected String region;
    protected Float costoImportacion;
    protected Float precio;
    protected Empaque empaque;
}
