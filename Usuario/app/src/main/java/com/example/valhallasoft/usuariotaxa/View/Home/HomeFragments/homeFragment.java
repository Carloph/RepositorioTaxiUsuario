package com.example.valhallasoft.usuariotaxa.View.Home.HomeFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.valhallasoft.usuariotaxa.R;

/**
 * Created by Sandoval on 27/03/2017.
 */

public class homeFragment extends Fragment {

    private String name="nombre";
    private String last="apellidos";

    private TextView tvName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        System.out.println(name);
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    public void setInfo(String name, String last) {
        this.name = name;
        this.last = last;
    }
}