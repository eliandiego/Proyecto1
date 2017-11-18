package org.fom.proyecto1;

import java.util.Vector;

/**
 * Created by FREDDY on 17/11/2017.
 */

public class AlmacenDemandasArray implements AlmacenDemandas {

    private Vector<String> puntuaciones;

    public AlmacenDemandasArray() {
        puntuaciones = new Vector<String>();
        puntuaciones.add("1 Pepito Domingez");
        puntuaciones.add("2 Pedro Martinez");
        puntuaciones.add("3 Paco Pérez");
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
