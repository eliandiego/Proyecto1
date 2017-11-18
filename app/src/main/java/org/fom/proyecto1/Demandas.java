package org.fom.proyecto1;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by FREDDY on 17/11/2017.
 */

public class Demandas extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demandas);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, PrincipalActivity.almacen.listaPuntuaciones(10)));

    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        Object o = getListAdapter().getItem(position);
        Toast.makeText(this, "Selección: " + Integer.toString(position) + " - " + o.toString(), Toast.LENGTH_LONG).show();
    }
}