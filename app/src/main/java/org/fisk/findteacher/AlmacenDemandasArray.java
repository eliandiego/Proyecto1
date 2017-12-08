package org.fisk.findteacher;

import java.util.Vector;

/**
 * Created by FREDDY on 17/11/2017.
 */

public class AlmacenDemandasArray implements AlmacenDemandas {

    private Vector<String> puntuaciones;

    public AlmacenDemandasArray() {
        puntuaciones = new Vector<String>();
        puntuaciones.add("ID0843. CLASES DE INFORMÁTICA. VALENCIA. 03/12/2017.(por Ana López)");
        puntuaciones.add("ID0845. CLASES DE INGLÉS. VALENCIA. 03/12/2017. (por Eva Anaya)");
        puntuaciones.add("ID0841. CLASES DE INGLÉS. ALICANTE. 02/12/2017.(por Luis Pérez)");
        puntuaciones.add("ID0838. CLASES DE JARDINERÍA. ALICANTE.01/12/2017.(por Paco Esteban)");
        puntuaciones.add("ID0830. CLASES DE INFORMÁTICA. MADRID.01/12/2017.(por Luisa Anaya)");
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
