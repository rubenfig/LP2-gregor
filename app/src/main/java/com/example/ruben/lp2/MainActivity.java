package com.example.ruben.lp2;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import layout.FragmentPerfil;
import layout.ListFragment;
import layout.ReservaDialogFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , ListFragment.OnListFragmentInteractionListener {

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
        ListFragment listFragment = ListFragment.newInstance(1);


        // Add the fragment to the 'fragment_form' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, listFragment).addToBackStack(null).commit();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_reserva) {
            // Handle the camera action
        } else if (id == R.id.nav_libros) {

            ListFragment listFragment = ListFragment.newInstance(1);


            // Add the fragment to the 'fragment_form' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content, listFragment).addToBackStack(null).commit();
        } else if (id == R.id.nav_perfil) {

            FragmentPerfil perfilFragment = FragmentPerfil.newInstance("param", "param");


            // Add the fragment to the 'fragment_form' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content, perfilFragment).addToBackStack(null).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onListFragmentInteraction(Libro item){
// Create a new Fragment to be placed in the activity layout
        ReservaDialogFragment dialog = new ReservaDialogFragment();
        Bundle args = new Bundle();
        args.putInt("dias", item.getDisponibilidad());
        args.putInt("id", item.getIsbnLibro());
        args.putString("descripcion", item.getDescripcion());
        args.putInt("disponibilidad", item.getDisponibilidad());
        dialog.setArguments(args);
        dialog.show(getFragmentManager(), "tag");


    }
}
