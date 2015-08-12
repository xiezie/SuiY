package com.example.lango.suiy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lango on 15/8/11.
 */
public class PersonalFragment extends BaseFragment {

    @Override
    protected CharSequence getFragmentTitle() {
        return getResources().getString(R.string.tab_personal);
    }

    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_personal, container, false);
    }
}
