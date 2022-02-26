package com.reactivo.app.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

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

    public String obtenerCostoTotalCafe(){
        return "El costo total de este cafe es "
                + this.costoImportacion
                + this.precio
                + this.empaque.getCosto()
                + (this.empaque.getPeso() * (this.empaque.getCosto()/100));
    }
}
