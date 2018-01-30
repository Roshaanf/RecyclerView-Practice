package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.R;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.StaggeredItemBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.ItemModel;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.StaggeredItem;

import java.util.List;

/**
 * Created by Roshaan on 1/30/2018.
 */

public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredViewHolder>  {

    List<StaggeredItem> data;

    public StaggeredAdapter(List<StaggeredItem> data) {

        this.data = data;
    }

    @Override
    public StaggeredViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        StaggeredItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.staggered_item,parent,false);
        return new StaggeredViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(StaggeredViewHolder holder, int position) {

        holder.setItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}


class StaggeredViewHolder extends RecyclerView.ViewHolder{

    StaggeredItemBinding binding;
    public StaggeredViewHolder(StaggeredItemBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }

    void setItem(final StaggeredItem data) {

        binding.imageView.setImageResource(data.getImage());

    }

}
