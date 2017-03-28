package com.example.valhallasoft.usuariotaxa.View.Home.HomeFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.valhallasoft.usuariotaxa.R;

/**
 * Created by Sandoval on 27/03/2017.
 */

public class homeFragment extends Fragment {

    private static int id_user=0;
    private static String name="nombre";
    private static String last="apellidos";

    private TextView tvName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.e("variable de nombre: ",name);
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        tvName = (TextView)view.findViewById(R.id.tvHomeName);
        tvName.setText("¡Hola "+name+"!");
    }
}