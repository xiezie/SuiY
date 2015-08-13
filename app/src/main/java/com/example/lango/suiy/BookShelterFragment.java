package com.example.lango.suiy;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by lango on 15/8/11.
 */
public class BookShelterFragment extends BaseFragment {
    private View rootView;
    private GridView gridView;
    private List<HashMap<String, Object>> data;
    @Override
    protected CharSequence getFragmentTitle() {
        return getResources().getString(R.string.tab_bkshelter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }
// TODO initinal data..
    private void initData() {
        data = new ArrayList<HashMap<String, Object>>();
        HashMap hashMap;
        for(int i = 0; i < 100; i++) {
            hashMap = new HashMap<String, Object>();
            hashMap.put("frontCover", R.mipmap.ic_booktest);
            hashMap.put("bookTitle", getActivity().getResources().getString(R.string.tab_bkshelter));
            hashMap.put("readState", getActivity().getResources().getString(R.string.read_state_t));
            hashMap.put("readProcess", i+" %");
            data.add(hashMap);
        }

    }

    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_bkshelter, container, false);
        init();
        setBookOverAdapter();
        setGridViewClickListener();
        return rootView;
    }

    private void setBookOverAdapter() {
        gridView.setAdapter(new BookPageOverAdapter(getActivity(), data, R.layout.item_front_cover));
    }

    private void setGridViewClickListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("text", "pos: " + position + "  id: " + id);
            }
        });
    }

    private void init() {
        gridView = (GridView) rootView.findViewById(R.id.fg_bk_page_over);
    }


}
