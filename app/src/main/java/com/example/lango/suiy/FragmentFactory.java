package com.example.lango.suiy;

import android.support.v4.app.Fragment;

/**
 * Created by lango on 15/8/11.
 */
public class FragmentFactory {
    public static BaseFragment getFragmentInstance(int checkId) {
        BaseFragment fragment = null;
        switch (checkId) {
            case R.id.tab_personal:
                fragment = new PersonalFragment();
                break;
            case R.id.tab_bkshelter:
                fragment = new BookShelterFragment();
                break;
            case R.id.tab_bkstore:
                fragment = new BookStoreFragment();
                break;
        }
        return  fragment;
    }
}
