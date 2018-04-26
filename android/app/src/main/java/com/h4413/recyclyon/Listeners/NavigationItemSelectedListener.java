package com.h4413.recyclyon.Listeners;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.h4413.recyclyon.Activities.Connection.ConnectionActivity;
import com.h4413.recyclyon.Activities.Deposit.DepositQRActivity;
import com.h4413.recyclyon.Activities.HomeActivity;
import com.h4413.recyclyon.Activities.ScanPackaging.ScanPackagingActivity;
import com.h4413.recyclyon.Activities.MapsActivity;
import com.h4413.recyclyon.R;

public class NavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {

    Activity mActivity;

    public NavigationItemSelectedListener(Activity activity) {
        mActivity = activity;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_homepage) {
            if(mActivity.getClass() != HomeActivity.class) {
                Intent intent = new Intent(mActivity.getApplicationContext(), HomeActivity.class);
                mActivity.startActivity(intent);
            }
        } else if (id == R.id.nav_deposit) {
            if(mActivity.getClass() != DepositQRActivity.class) {
                Intent intent = new Intent(mActivity.getApplicationContext(), DepositQRActivity.class);
                mActivity.startActivity(intent);
            }
        } else if (id == R.id.nav_account) {

        } else if (id == R.id.nav_map) {
            if(mActivity.getClass() != MapsActivity.class) {
                Intent intent = new Intent(mActivity.getApplicationContext(), MapsActivity.class);
                mActivity.startActivity(intent);
            }
        } else if (id == R.id.nav_scan) {
            if(mActivity.getClass() != ScanPackagingActivity.class)
            {
                Intent intent = new Intent(mActivity.getApplicationContext(), ScanPackagingActivity.class);
                mActivity.startActivity(intent);
            }
        } else if (id == R.id.nav_schedule) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_logout) {
            Intent intent = new Intent(mActivity.getApplicationContext(), ConnectionActivity.class);
            mActivity.startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) mActivity.findViewById(R.id.template_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}