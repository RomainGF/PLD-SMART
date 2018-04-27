package com.h4413.recyclyon.Utilities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.h4413.recyclyon.Listeners.NavigationItemSelectedListener;
import com.h4413.recyclyon.Model.User;
import com.h4413.recyclyon.R;

import org.json.JSONObject;

public class NavbarInitializer {
    public static void initNavigationMenu(final AppCompatActivity activity, @IdRes int checkedItem, @StringRes int title) {
        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        activity.setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) activity.findViewById(R.id.template_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(activity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) activity.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationItemSelectedListener(activity));
        navigationView.setCheckedItem(checkedItem);
        final View headerLayout = navigationView.getHeaderView(0);

        Intent intent = activity.getIntent();
        String idUtilisateur = intent.getStringExtra(SharedPreferencesKeys.ID_USER_KEY);
        if(idUtilisateur == null){
            Gson gson = new Gson();
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext());
            String str = sharedPref.getString(SharedPreferencesKeys.USER_KEY, "");
            User usr = gson.fromJson(str, User.class);
            idUtilisateur = usr._id;
        }
        HttpClient.GET(Routes.Users, idUtilisateur, activity, new HttpClient.OnResponseCallback() {
            @Override
            public void onJSONResponse(int statusCode, JSONObject response) {
                Gson gson = new Gson();
                User mUser = gson.fromJson(response.toString(), User.class);
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext());
                sharedPref.edit().putString(SharedPreferencesKeys.USER_KEY, response.toString()).apply();
                ((TextView)headerLayout.findViewById(R.id.nav_header_username)).setText(mUser.nom);
                ((TextView)headerLayout.findViewById(R.id.nav_header_usermail)).setText(mUser.mail);
            }
        });
    }
}