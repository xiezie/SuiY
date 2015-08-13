package com.example.lango.suiy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lango on 15/8/11.
 */
public abstract class BaseFragment extends Fragment {

    private ActionBar actionBar;

    public void getActionBar(ActionBar actionBar) {
        this.actionBar = actionBar;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = getFragmentView(inflater, container, savedInstanceState);
        if(actionBar != null) {
            customActionBar();
        }
        return view;
    }

    /**
     * change title.
     * if you wanna to custom the actionbar, do not forget to add super.customActionBar();
     */
    private void customActionBar() {
        actionBar.setTitle(getFragmentTitle());
    }

    /**
     * get a string from sub fragment
     * aim to reset the title of actionBar
     * @return
     */
    protected abstract CharSequence getFragmentTitle();

    /**
     * get a view of each sub fragment
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public abstract View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

}
