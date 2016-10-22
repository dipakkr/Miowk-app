package com.dipakkr.github.miowkapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by deepak on 22-10-2016.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    public SimpleFragmentPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersActivity();
        }
        else if (position == 1) {
            return new FamilyActivity();
        }
        else if (position == 2) {
            return new ColorsActivity();
        }
         else {
            return new PhrasesActivity();
        }

    }

    @Override
    public int getCount() {
        return 4;
    }
}
