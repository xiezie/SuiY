package com.example.lango.suiy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lango on 15/8/12.
 */
public class BookPageOverAdapter extends CommonAdapter {

    public BookPageOverAdapter(Context context, List data, int layoutId) {
        super(context, data, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, Object data) {
        holder.setText(R.id.book_title, (String)((HashMap<String,Object>) data).get("bookTitle"))
                .setText(R.id.read_process, (String)((HashMap<String,Object>) data).get("readProcess"))
                .setText(R.id.read_state, (String)((HashMap<String,Object>) data).get("readState"))
                .setImageResource(R.id.front_cover, (Integer)((HashMap<String, Object>) data).get("frontCover"));
    }

}
