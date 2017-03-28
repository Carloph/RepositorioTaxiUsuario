package com.example.valhallasoft.usuariotaxa.View.Home.HomeFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.valhallasoft.usuariotaxa.R;

/**
 * Created by Sandoval on 27/03/2017.
 */

public class dashFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dash_fragment, container, false);
    }
}
