package com.example.valhallasoft.usuariotaxa.View.Home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.valhallasoft.usuariotaxa.R;
import com.example.valhallasoft.usuariotaxa.Utils.Util;

public class Home extends AppCompatActivity {

    int id;
    public String email;
    public String name;
    public String last;
    public String number;

    private Fragment fragment;
    private FragmentManager fragmentManager;
    private TextView mTextMessage;

    private SharedPreferences preferences;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fragmentManager = getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    main_home.newInstance(name,last);
                    fragment = new main_home();
                    break;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content,fragment).commit();
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(savedInstanceState == null){
            getDataPreferences();
        }

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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
