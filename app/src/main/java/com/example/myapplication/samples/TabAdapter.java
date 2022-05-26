package com.example.myapplication.samples;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.concurrent.Callable;

public class TabAdapter extends FragmentStatePagerAdapter {
int numoftabs;

    public TabAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        numoftabs=tabCount;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Chat chat=new Chat();
                return chat;
            case 1:
                Status status=new Status();
                return status;
            case 2:
                Call call=new Call();
                return call;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numoftabs;
    }
}
