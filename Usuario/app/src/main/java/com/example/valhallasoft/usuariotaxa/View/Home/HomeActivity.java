package com.example.valhallasoft.usuariotaxa.View.Home;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.valhallasoft.usuariotaxa.R;
import com.example.valhallasoft.usuariotaxa.Utils.Util;
import com.example.valhallasoft.usuariotaxa.View.Home.HomeFragments.dashFragment;
import com.example.valhallasoft.usuariotaxa.View.Home.HomeFragments.homeFragment;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    public int id;
    public static String email;
    public static String name;
    public static String last;
    public static String number;

    private SharedPreferences preferences;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(savedInstanceState == null) {
            getDataPreferences();
        }
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        onNavigationItemSelected(bottomNavigationView.getMenu().getItem(0));

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()){
            case R.id.navigation_home:
                pushFragment(new homeFragment().newInstance(id,name,last));
                break;
            case R.id.navigation_dashboard:
                pushFragment(new dashFragment());
                break;
        }
        return false;
    }

    protected void pushFragment(Fragment fragment){
        if(fragment==null) return;

        FragmentManager fragmentManager = getFragmentManager();
        if(fragmentManager!=null){
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if(ft!=null){
                ft.replace(R.id.main_content,fragment);
                ft.commit();
            }
        }
    }

    private void getDataPreferences(){
        preferences =  getSharedPreferences("preferences", Context.MODE_PRIVATE);
        this.id = Util.getIdUser(preferences);
        this.email = Util.getEmailPreference(preferences);
        this.name = Util.getNamePreference(preferences);
        this.last = Util.getLastNPreference(preferences);
        this.number = Util.getNumberPreference(preferences);
    }

}
