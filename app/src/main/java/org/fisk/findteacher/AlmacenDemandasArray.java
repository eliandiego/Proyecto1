package org.fisk.findteacher;

import java.util.Vector;

/**
 * Created by FREDDY on 17/11/2017.
 */

public class AlmacenDemandasArray implements AlmacenDemandas {

    private Vector<String> puntuaciones;

    public AlmacenDemandasArray() {
        puntuaciones = new Vector<String>();
        puntuaciones.add("1 CLASES DE INFORMÁTICA(por Luis)");
        puntuaciones.add("2 CLASES DE INGLÉS (por Pedro Martínez)");
        puntuaciones.add("3 CLASES DE INGLÉS (por Ana Pérez)");
        puntuaciones.add("4 CLASES DE JARDINERÍA (por Paco Pérez)");
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
