package org.fom.proyecto1;

import java.util.Vector;

/**
 * Created by FREDDY on 17/11/2017.
 */

public interface AlmacenDemandas {

    public void guardarPuntuacion(int puntos, String nombre, long fecha);

    public Vector<String> listaPuntuaciones(int cantidad);
}
