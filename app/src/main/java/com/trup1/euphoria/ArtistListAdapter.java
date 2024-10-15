package com.trup1.euphoria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ArtistListAdapter extends ArrayAdapter<String> {
    public ArtistListAdapter(Context context, List<String> artists) {
        super(context, 0, artists);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String artist = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(artist);

        return convertView;
    }
}


