package com.example.lango.suiy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by lango on 15/8/13.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<T> data;
    private Context context;
    private int layoutId;

    public CommonAdapter(Context context, List<T> data, int layoutId) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        this.data = data;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    public void changeDataSet(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(context, convertView, parent, layoutId, position);
        convert(holder, data.get(position));
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder, T data);
}
