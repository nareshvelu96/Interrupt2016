package in.svce.interrupt16.android;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.primary));

        //TextView textView = (TextView) findViewById(R.id.nav_title);
        //Typeface fontRobo1 = Typeface.createFromAsset(getAssets(),"fonts/BOMBARD_.ttf");
        //textView.setTypeface(fontRobo1);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        Button share=(Button)findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "INTERRUPT - A National Level Technical Symposium\n" +
                        "\n" +
                        "Organized be Association of Computer Engineering and Department of CSE , SVCE.\n" +
                        "\n" +
                        "Get Ready to Get Interrupted on October 1st\n" +
                        "\n" +
                        "Also, visit Web - www.interrupt16.in and Facebook page -\n" +
                        "\n" +
                        "facebook.com/svceinterrupt\nDownload the Interrupt app from\nhttps://play.google.com/store/apps/details?id=in.svce.interrupt16.android";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "INTERRUPT");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new aboutInterrupt()).commit();


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
            fragmentManager.beginTransaction().replace(R.id.content_frame, new aboutInterrupt()).commit();

        } else if (id == R.id.nav_events) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new events_fragment()).commit();
        } else if (id == R.id.nav_transport) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new transport()).commit();
        } else if (id == R.id.nav_map) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new svcemap()).commit();
        } else if (id == R.id.nav_reg) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new eventreg()).commit();
        } else if (id == R.id.nav_contact) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new contact()).commit();
        } else if (id == R.id.nav_sponsors) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new spons()).commit();
        } else if (id == R.id.nav_ins) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new inst()).commit();
        } else if (id == R.id.nav_letsgo) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new letsgo()).commit();
        } else if (id == R.id.nav_chat) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new ChatActivity()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //Ask the user if they want to quit
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Stay Interrupted!!")
                    .setMessage("Do you really want to exit the app?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            //Stop the activity
                            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                            homeIntent.addCategory( Intent.CATEGORY_HOME );
                            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(homeIntent);

                        }

                    })
                    .setNegativeButton("No", null)
                    .show();

            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }

    }
}
