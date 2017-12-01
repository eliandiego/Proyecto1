package org.fisk.findteacher;

import android.view.View;

/**
 * Created by Kelvin on 21/11/2017.
 */

public interface DemandaItemClickListener {

    void itemClickListener(int position , View view);

    void infoClickListener(String name);
}
