package com.example.digital_indenting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.digital_indenting.databinding.ActivityHomeBinding;

public class home extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        setSupportActionBar(binding.appBarHome.toolbar);
//        binding.appBarHome.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            Intent i = new Intent(getApplicationContext(),home.class);
            startActivity(i);
        }
        if (id == R.id.nav_gallery) {
            Intent i = new Intent(getApplicationContext(),Profilr.class);
            startActivity(i);
        }
        if (id == R.id.nav_slideshow1) {
            Intent i = new Intent(getApplicationContext(),view_labequipments.class);
            startActivity(i);
        }
        if (id == R.id.nav_attendene) {
            Intent i = new Intent(getApplicationContext(),my_attendence.class);
            startActivity(i);
        }
        if (id == R.id.nav_logout){
            Intent i = new Intent(getApplicationContext(),login.class);
            startActivity(i);
        }
        if (id == R.id.nav_damage){
            Intent i = new Intent(getApplicationContext(),view_damagereport.class);
            startActivity(i);
        }
        return true;
    }

}


//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

