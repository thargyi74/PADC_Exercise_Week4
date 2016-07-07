package com.thargyi.padc_exercise_week4.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.thargyi.padc_exercise_week4.R;
import com.thargyi.padc_exercise_week4.fragments.JobSearchFragment;
import com.thargyi.padc_exercise_week4.fragments.LinkInFragment;
import com.thargyi.padc_exercise_week4.fragments.MovieFragment;
import com.thargyi.padc_exercise_week4.fragments.PulseFragment;
import com.thargyi.padc_exercise_week4.fragments.WinZinFragment;
import com.thargyi.padc_exercise_week4.utils.MMFontUtils;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new LinkInFragment()).commit();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        //Menu leftMenu = mNavigationView.getMenu();
        //MMFontUtils.applyMMFontToMenu(leftMenu);
        mNavigationView.setNavigationItemSelectedListener(this);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == android.R.id.home){
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(final MenuItem menuItem) {
        menuItem.setChecked(true);
        mDrawerLayout.closeDrawers();

        final Fragment[] fragment = new Fragment[1];

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (menuItem.getItemId()){
                    case R.id.left_menu_linkin:
                        fragment[0] = new LinkInFragment();
                        break;
                    case R.id.left_menu_job_search:
                        fragment[0] = new JobSearchFragment();
                        break;
                    case R.id.left_menu_pulse:
                        fragment[0] = new PulseFragment();
                        break;
                    case R.id.left_menu_movies:
                        fragment[0] = new MovieFragment();
                        break;
                    case R.id.left_menu_win_zin:
                        fragment[0] = new WinZinFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment[0]).commit();
            }
        }, 500); //to close drawer smoothly.

        return true;
    }
}
