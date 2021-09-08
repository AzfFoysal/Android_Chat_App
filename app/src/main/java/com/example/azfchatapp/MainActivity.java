package com.example.azfchatapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.os.Bundle;

import com.example.azfchatapp.databinding.ActivityMainBinding;
import com.example.azfchatapp.databinding.ActivityMainBindingImpl;
import com.example.azfchatapp.menu.ChatsFragment;
import com.example.azfchatapp.menu.ContactsFragment;
import com.example.azfchatapp.menu.StatusFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(  this,R.layout.activity_main);

        setUpViewPager(binding.viewPager);
        binding.tabLayout.setupWithViewPager(binding.viewPager);


    }


    private void setUpViewPager (ViewPager viewPager)
    {
        MainActivity.SectionsPagerAdapter adapter = new  SectionsPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new ChatsFragment(), "Chat");
        adapter.addFragment(new StatusFragment(), "Status");
        adapter.addFragment(new ContactsFragment(), "Contacts");

        viewPager.setAdapter(adapter);



    }

    private static class SectionsPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter (FragmentManager manager)
        {
            super(manager);
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment (Fragment fragment, String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}