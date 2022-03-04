package com.reactivo.app.usecase;

import com.reactivo.app.modelos.Cafe;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CafeUseCase {

    public String obtenerCostoTotalCafeCadena(Cafe cafe){
        return "El costo total de este cafe es "
                + cafe.getCostoImportacion()
                + cafe.getPrecio()
                + cafe.getEmpaque().getCosto()
                + (cafe.getEmpaque().getPeso() * (cafe.getEmpaque().getCosto()/100));
    }
}
