package com.example.proco;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class TopNavigationViewHelper {
    private static final String TAG = "TopNavigationViewHelper";

    public static void setupTopNavigationView(BottomNavigationViewEx tv) {
        Log.d(TAG, "setupTopNavigationView: setting up navigation view");
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.ic_profile) {
                    Intent i = new Intent(context, SettingsActivity.class);
                    context.startActivity(i);
                }
                if (item.getItemId()==R.id.ic_matched) {
                    Intent i1 = new Intent(context, MatchesActivity.class);
                    context.startActivity(i1);
                }
                return false;
            }
        });
    }
}
