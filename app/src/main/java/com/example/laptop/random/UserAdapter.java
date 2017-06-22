package com.example.laptop.random;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class UserAdapter extends ArrayAdapter<Custom> {
    public UserAdapter(Activity context, ArrayList<Custom> androidFlavors) {
        super(context, 0, androidFlavors);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }
        Custom a = getItem(position);
        TextView name = (TextView) listItemView.findViewById(R.id.idd);
        name.setText(a.GETA());
        TextView habit = (TextView) listItemView.findViewById(R.id.iddd);
        habit.setText(a.GETB());
        TextView age = (TextView) listItemView.findViewById(R.id.idddd);
        age.setText(a.GETC());
        return listItemView;
    }
}


