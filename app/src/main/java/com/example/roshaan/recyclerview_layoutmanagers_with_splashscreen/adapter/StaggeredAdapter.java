package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.R;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.StaggeredItemBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.listeners.Callback;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.ItemModel;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.StaggeredItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roshaan on 1/30/2018.
 */

public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredViewHolder> {

    List<StaggeredItem> data;
    Callback callback;

    public StaggeredAdapter(List<StaggeredItem> data,Callback callback) {

        this.data = data;
        this.callback=callback;
    }

    @Override
    public StaggeredViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        StaggeredItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.staggered_item, parent, false);
        return new StaggeredViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(StaggeredViewHolder holder, int position) {

        holder.setItem(data.get(position),callback,position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}


class StaggeredViewHolder extends RecyclerView.ViewHolder {

    StaggeredItemBinding binding;

    //adding class paramter just to differentiate which adapter is making object of this class
    public StaggeredViewHolder(StaggeredItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void setItem(final StaggeredItem data) {

        binding.imageView.setImageResource(data.getImage());

    }


    void setItem(final StaggeredItem data, final Callback callback,int position) {

        //setting dynamically transition name to eachitem
        // because each view should have unique transition name in xml
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.imageView.setTransitionName(String.valueOf(position));
        }

        binding.imageView.setImageResource(data.getImage());

        binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Object> object=new ArrayList<>();
                object.add(data.getImage());
                object.add(binding.imageView);

                callback.invoke(object);
            }
        });
    }


}



