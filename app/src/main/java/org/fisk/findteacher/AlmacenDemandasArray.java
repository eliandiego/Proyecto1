package org.fisk.findteacher;

import java.util.Vector;

/**
 * Created by FREDDY on 17/11/2017.
 */

public class AlmacenDemandasArray implements AlmacenDemandas {

    private Vector<String> puntuaciones;

    public AlmacenDemandasArray() {
        puntuaciones = new Vector<String>();
        puntuaciones.add("1. CLASES DE INFORMÁTICA. VALENCIA. 02/12/2017. (por Luis Pérez)");
        puntuaciones.add("2. CLASES DE INGLÉS. VALENCIA. 01/12/2017. (por Pedro Martínez)");
        puntuaciones.add("3. CLASES DE INGLÉS. ALICANTE. 02/12/2017. (por Ana Pérez)");
        puntuaciones.add("4. CLASES DE JARDINERÍA. 02/12/2017. ALICANTE(por Paco Pérez)");
    }

    @Override
    public void guardarPuntuacion(int puntos, String nombre, long fecha) {
        puntuaciones.add(0, puntos + " " + nombre);
    }

    @Override
    public Vector<String> listaPuntuaciones(int cantidad) {
        return puntuaciones;
    }
}
