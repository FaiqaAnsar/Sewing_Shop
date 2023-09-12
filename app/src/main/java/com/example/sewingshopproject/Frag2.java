package com.example.sewingshopproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Frag2 extends FragmentPagerAdapter {
    private int tabno;
    private int position;

    public Frag2(@NonNull FragmentManager fm, int behavior, int tabno) {
        super(fm, behavior);
        this.tabno = tabno;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new p2();
            case 1:
                return new o2();
            case 2:
                return new f2();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabno;
    }
}
