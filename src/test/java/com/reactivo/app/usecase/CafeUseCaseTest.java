package com.reactivo.app.usecase;

import com.reactivo.app.modelos.Cafe;
import com.reactivo.app.modelos.Empaque;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CafeUseCaseTest {

    //TODO: Ajustar el metodo obtenerCostoTotalCafeCadena y el test
    @Test
    void obtenerCostoTotalCafeCadenaCafeConDatosNoCero() {
        Empaque empaquePrueba = new Empaque("empaquePrueba", "Prueba empaque", 10f,
                1f, 100);
        Cafe cafePrueba = new Cafe("A001", "variedadPrueba",100,
                "regionPrueba",12f, 10f,empaquePrueba);

        String resultadoEsperado = "El costo total de este cafe es 12.010.01.00.099999994";

        CafeUseCase cafeUseCase = new CafeUseCase();
        assertEquals(resultadoEsperado, cafeUseCase.getCostoCafeBySerialMono(cafePrueba.getSerial()).block());
    }

    @Test
    void obtenerCostoTotalCafeCadenaCafeNulo() {
        String resultadoEsperado = "El cafe no existe";

        CafeUseCase cafeUseCase = new CafeUseCase();
        assertEquals(resultadoEsperado, cafeUseCase.getCostoCafeBySerialMono(null).block());
    }

    @Test
    void obtenerCostoTotalCafeCadenaCafeEmpaqueNulo() {
        String resultadoEsperado = "El cafe no tiene empaque";
        Cafe cafePrueba = new Cafe("A001", "variedadPrueba",100,
                "regionPrueba",12f, 10f, null);
        CafeUseCase cafeUseCase = new CafeUseCase();
        assertEquals(resultadoEsperado, cafeUseCase.getCostoCafeBySerialMono(cafePrueba.getSerial()).block());
    }

    @Test
    void obtenerCostoTotalCafeCadenaCafeCostoPrecioPesoCero() {
        Empaque empaquePrueba = new Empaque("empaquePrueba", "Prueba empaque", 0f,
                0f, 100);
        Cafe cafePrueba = new Cafe("A001", "variedadPrueba",100,
                "regionPrueba",0f, 0f,empaquePrueba);

        String resultadoEsperado = "El costo total de este cafe es 0.00.00.00.0";

        CafeUseCase cafeUseCase = new CafeUseCase();
        assertEquals(resultadoEsperado, cafeUseCase.getCostoCafeBySerialMono(cafePrueba.getSerial()).block());
    }
}