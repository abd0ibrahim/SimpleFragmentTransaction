package com.khoroga.abdo.projecttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonAddBlueFragment;
    private Button buttonAddRedFragment;
    private Button buttonAddGreenFragment;
    private TextView textViewFragmentCount;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        fragmentManager = getSupportFragmentManager();

//        textViewFragmentCount.setText(Integer.toString(fragmentManager.getBackStackEntryCount()));
        initListeners();
    }

    private void initListeners() {
        buttonAddBlueFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new BlueFragment());
            }
        });

        buttonAddRedFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new RedFragment());
            }
        });

        buttonAddGreenFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new GreenFragment());
            }
        });

    }

    private void initViews() {
        buttonAddBlueFragment = (Button) findViewById(R.id.buttonAddBlueFragment);
        buttonAddRedFragment = (Button) findViewById(R.id.buttonAddRedFragment);
        buttonAddGreenFragment = (Button) findViewById(R.id.buttonAddGreenFragment);
        textViewFragmentCount = findViewById(R.id.textViewFragmentCount);
    }

    private void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment, "demoFragment");
        fragmentTransaction.commit();
    }
}
