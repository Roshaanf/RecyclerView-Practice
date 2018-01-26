package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.R;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.LinearVerticalItemBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.ItemModel;

import java.util.List;

/**
 * Created by Roshaan on 1/25/2018.
 */

public class LinearVerticalAdapter extends RecyclerView.Adapter<LinearVerticalAdapter.LinearVerticalViewHolder> {

    List<ItemModel> data;

    public LinearVerticalAdapter(List<ItemModel> data) {
        this.data = data;
    }

    @Override
    public LinearVerticalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LinearVerticalItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.linear_vertical_item,parent,false);

        return new LinearVerticalViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(LinearVerticalViewHolder holder, int position) {

        holder.setItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class LinearVerticalViewHolder extends RecyclerView.ViewHolder{

        LinearVerticalItemBinding binding;

        public LinearVerticalViewHolder(LinearVerticalItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        void setItem(ItemModel data){

            binding.imageView.setImageResource(data.getImage());
            binding.textView.setText(data.getName());
        }
    }
}
