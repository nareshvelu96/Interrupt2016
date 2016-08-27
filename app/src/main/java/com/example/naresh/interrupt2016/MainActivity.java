package com.example.naresh.interrupt2016;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame,new aboutInterrupt()).commit();



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        if (id == R.id.nav_about) {
            fragmentManager.beginTransaction().replace(R.id.content_frame,new aboutInterrupt()).commit();

        } else if (id == R.id.nav_events) {
            fragmentManager.beginTransaction().replace(R.id.content_frame,new events_fragment()).commit();
        } else if (id == R.id.nav_transport) {
            fragmentManager.beginTransaction().replace(R.id.content_frame,new transport()).commit();
        } else if (id == R.id.nav_why) {
            fragmentManager.beginTransaction().replace(R.id.content_frame,new whyapp()).commit();
        } else if (id == R.id.nav_map) {
            fragmentManager.beginTransaction().replace(R.id.content_frame,new svcemap()).commit();
        } else if (id == R.id.nav_reg) {
            fragmentManager.beginTransaction().replace(R.id.content_frame,new eventreg()).commit();
        } else if (id == R.id.nav_contact){
            fragmentManager.beginTransaction().replace(R.id.content_frame,new contact()).commit();
        } else if (id == R.id.nav_sponsors) {
            fragmentManager.beginTransaction().replace(R.id.content_frame,new spons()).commit();
        } else if (id == R.id.nav_ins){
            fragmentManager.beginTransaction().replace(R.id.content_frame,new inst()).commit();
        } else if (id == R.id.nav_letsgo){
            fragmentManager.beginTransaction().replace(R.id.content_frame,new letsgo()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
