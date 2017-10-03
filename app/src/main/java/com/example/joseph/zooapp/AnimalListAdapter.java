package com.example.joseph.zooapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by joseph on 10/3/17.
 */

public class AnimalListAdapter extends ArrayAdapter<Animal>{


    public AnimalListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Animal> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        //inflate the view with the custom layout xml
        if(view == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, null);
        }

        //bind all the views
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvType = view.findViewById(R.id.tvType);

        Animal animal = getItem(position);
        tvName.setText(animal.getName());
        tvType.setText(animal.getType());

        //instead of returning super function we create and return a custom view
//        return super.getView(position, convertView, parent);
        return view;
    }
}
