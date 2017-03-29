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

    public int id_user=0;
    public String name="nombre";
    public String last="apellidos";

    private TextView tvName;

    public static homeFragment newInstance(int id, String name,String last) {
        homeFragment fragmentDemo = new homeFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        args.putString("name", name);
        args.putString("last", last);
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id_user = getArguments().getInt("id",0);
        name = getArguments().getString("name","");
        last = getArguments().getString("last","");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        tvName = (TextView)view.findViewById(R.id.tvHomeName);
        tvName.setText("¡Hola "+name+" "+last+"!");
    }
}