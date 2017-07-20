package com.andrebondar.andrepdd.screens.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.andrebondar.andrepdd.R;
import com.andrebondar.andrepdd.screens.fragments.AutoHistoryFragment;
import com.andrebondar.andrepdd.screens.fragments.BookListFragment;
import com.andrebondar.andrepdd.screens.fragments.TestListFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BookListFragment bookListFragment;
    private TestListFragment testListFragment;
    private FragmentTransaction transaction;

    private AutoHistoryFragment autoHistoryFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_main_drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bookListFragment = new BookListFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.content_main, bookListFragment);
        transaction.commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_main_drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.activity_main_drawer_book) {         //don't work!!!!!!!!!!!!!!!!!!!!!!!
            //if (transaction != null && testListFragment.isAdded()) {
                bookListFragment = new BookListFragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_main, bookListFragment);
                transaction.commit();
        } else if (id == R.id.activity_main_drawer_test) {
            if (transaction != null) {
                testListFragment = new TestListFragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_main, testListFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        } else if (id == R.id.activity_main_drawer_history) {
            autoHistoryFragment = new AutoHistoryFragment();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_main, autoHistoryFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (id == R.id.activity_main_drawer_settings) {
            Intent intent = new Intent(MainActivity.this, AppSettings.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_main_drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
