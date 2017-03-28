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

import com.example.valhallasoft.usuariotaxa.R;
import com.example.valhallasoft.usuariotaxa.Utils.Util;
import com.example.valhallasoft.usuariotaxa.View.Home.HomeFragments.dashFragment;
import com.example.valhallasoft.usuariotaxa.View.Home.HomeFragments.homeFragment;

public class Home extends AppCompatActivity {

    int id;
    public static String email;
    public static String name;
    public static String last;
    public static String number;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(savedInstanceState == null) {
            getDataPreferences();
        }
        setupNavigationView();
    }

    private void setupNavigationView(){

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        if(bottomNavigationView!=null){

            Menu menu = bottomNavigationView.getMenu();
            selectFragment(menu.getItem(0));

            bottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            selectFragment(item);
                            return false;
                        }
                    });

        }
    }

    protected void selectFragment(MenuItem item){

        item.setChecked(true);

        switch (item.getItemId()){
            case R.id.navigation_home:
                pushFragment(new homeFragment());
                break;
            case R.id.navigation_dashboard:
                pushFragment(new dashFragment());
                break;
        }
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
        preferences =  getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        id = Util.getIdUser(preferences);
        email = Util.getNamePreference(preferences);
        name = Util.getLastNPreference(preferences);
        last = Util.getLastNPreference(preferences);
        number = Util.getNumberPreference(preferences);
    }
}
