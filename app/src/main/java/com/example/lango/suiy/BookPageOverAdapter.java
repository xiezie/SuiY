package com.example.lango.suiy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lango on 15/8/12.
 */
public class BookPageOverAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<HashMap<String, Object>> data;

    public BookPageOverAdapter(Context context, List data) {
        mInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.front_cover, parent, false);
            viewHolder.bookTitle = (TextView) convertView.findViewById(R.id.book_title);
            viewHolder.frontCover = (ImageView) convertView.findViewById(R.id.front_cover);
            viewHolder.readProcess = (TextView) convertView.findViewById(R.id.read_process);
            viewHolder.readState = (TextView) convertView.findViewById(R.id.read_state);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.bookTitle.setText((String)data.get(position).get("bookTitle"));
        viewHolder.frontCover.setImageResource((Integer) data.get(position).get("frontCover"));
        viewHolder.readState.setText((String) data.get(position).get("readState"));
        viewHolder.readProcess.setText((String) data.get(position).get("readProcess"));

        return convertView;
    }

    private class ViewHolder {
        private ImageView frontCover;
        private TextView bookTitle;
        private TextView readState;
        private TextView readProcess;
    }

}
