package com.wowaps.namostute;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
       {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ActionBar mActionBar;

    private static final String TAG = "MainActivity.class";

   // private int[] tabIcons = {R.drawable.media_tab_selector, R.drawable.playlist_selector};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mActionBar = getSupportActionBar();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(mViewPager);
        mTabLayout = (TabLayout) findViewById(R.id.media_tabs);
        mTabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);

    }

    private void setupTabIcons() {
        mTabLayout.getTabAt(0).setText("Bhajan");
        mTabLayout.getTabAt(1).setText("Chalisa");
        mTabLayout.getTabAt(2).setText("Aarti");
        mTabLayout.getTabAt(3).setText("Mantr");
        mTabLayout.getTabAt(4).setText("Vrat Katha");
        mTabLayout.getTabAt(5).setText("Pooja vidhi");
        mTabLayout.getTabAt(6).setText("Upaay/Totke");
        mTabLayout.getTabAt(7).setText("TV Serials");
        mTabLayout.getTabAt(8).setText("Devotional world");
        mTabLayout.getTabAt(9).setText("Shabad Gurubani");
        mTabLayout.getTabAt(10).setText("Bhakti sagar");
        mTabLayout.getTabAt(11).setText("Islamic devotional");
        mTabLayout.getTabAt(12).setText("Sadhguru");
        mTabLayout.getTabAt(13).setText("Brahma Kumari");
        mTabLayout.getTabAt(14).setText("The Art of living");



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  clearValues();
    }

   /* private void clearValues() {
        tabIcons = null;
    }*/

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
        getMenuInflater().inflate(R.menu.main, menu);
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
        }

        return super.onOptionsItemSelected(item);
    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new CategoryFragment());
        adapter.addFrag(new CategoryFragment());
        adapter.addFrag(new CategoryFragment());
        adapter.addFrag(new CategoryFragment());
        adapter.addFrag(new CategoryFragment());
        adapter.addFrag(new CategoryFragment());
        adapter.addFrag(new CategoryFragment());
        adapter.addFrag(new CategoryFragment());
        adapter.addFrag(new CategoryFragment());
        adapter.addFrag(new CategoryFragment());
        adapter.addFrag(new CategoryFragment());
        adapter.addFrag(new CategoryFragment());
        adapter.addFrag(new CategoryFragment());
        adapter.addFrag(new CategoryFragment());
        adapter.addFrag(new CategoryFragment());



        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    // mActionBar.setTitle(getString(R.string.Instagram_Photos));
                } else if (position == 1) {
                    // mActionBar.setTitle(getString(R.string.Videos));
                }
            }
        });
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment) {
            mFragmentList.add(fragment);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }

}
