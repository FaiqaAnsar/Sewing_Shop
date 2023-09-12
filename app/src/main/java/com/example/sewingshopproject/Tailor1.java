package com.example.sewingshopproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Tailor1 extends AppCompatActivity {
    TabLayout tab;
    TabItem tab1,tab2,tab3;
    ViewPager viewpager;
    Frag1 frag1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tailor1);
        tab = (TabLayout) findViewById(R.id.tab1);
        tab1 = (TabItem) findViewById(R.id.profile);
        tab2 = (TabItem) findViewById(R.id.od1);
        tab3 = (TabItem) findViewById(R.id.f1);
        viewpager = (ViewPager) findViewById(R.id.vp1);

        frag1 = new Frag1(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tab.getTabCount());
        viewpager.setAdapter(frag1);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2)
                  frag1.notifyDataSetChanged();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

    }
}