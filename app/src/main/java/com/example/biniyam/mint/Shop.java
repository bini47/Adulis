package com.example.biniyam.mint;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

public class Shop extends Fragment {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private View rootView;
    private ViewPager mViewPager;
    Bundle bundle = new Bundle();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.activity_shop, container, false);
        // We need to use the SupportActionBar from android.support.v7.app.ActionBar until the minimum API is >= 21.
        Toolbar supportAppBar = (Toolbar) rootView.findViewById(R.id.toolbar);

        mViewPager = (ViewPager) rootView.findViewById(R.id.container);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        mViewPager.setAdapter(new SectionsPagerAdapter(getFragmentManager()));
        // Set up the ViewPager with the sections adapter.


        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
         tabLayout.setupWithViewPager(mViewPager);


        return rootView;
    }




    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int tab) {
            return CategoryTabFragment.createTab(tab);
        }
        @Override
        // Get the name of each tab.  Tab numbers start at 0.
        public CharSequence getPageTitle(int tab) {
            switch (tab) {
                case 0:
                    return getString(R.string.tab_text_0);

                case 1:
                    return getString(R.string.tab_text_1);

                case 2:
                    return getString(R.string.tab_text_2);

                case 3:
                    return getString(R.string.tab_text_3);

                case 4:
                    return getString(R.string.tab_text_4);

                case 5:
                    return getString(R.string.tab_text_5);

                case 6:
                    return getString(R.string.tab_text_6);
                case 7:
                    return getString(R.string.tab_text_7);

                default:
                    return "";
            }
        }
        @Override
        public int getCount() {
            // Show 8 total pages.
            return 8;
        }
    }
}
