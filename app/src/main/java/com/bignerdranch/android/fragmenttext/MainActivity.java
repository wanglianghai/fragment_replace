package com.bignerdranch.android.fragmenttext;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements FragmentTop.CallBacks {
    private FragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mManager = getSupportFragmentManager();
        Fragment fragment = mManager.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = new FragmentOne();
            mManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
        Fragment fragmentTop = mManager.findFragmentById(R.id.fragment_top);
        if (fragmentTop == null) {
            fragmentTop = new FragmentTop();
            mManager.beginTransaction()
                    .add(R.id.fragment_top, fragmentTop)
                    .commit();
        }
    }

    public void upDateFragment(Fragment fragment) {
        mManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
