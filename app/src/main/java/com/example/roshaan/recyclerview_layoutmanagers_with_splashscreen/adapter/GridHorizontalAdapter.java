package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.R;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.GridHorizontalItemBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.ItemModel;

import java.util.List;

/**
 * Created by Roshaan on 1/26/2018.
 */

public class GridHorizontalAdapter extends RecyclerView.Adapter<GridHorizontalAdapter.GridHorizontalViewHolder>{

    List<ItemModel> data;

    public GridHorizontalAdapter(List<ItemModel> data) {
        this.data = data;
    }

    @Override
    public GridHorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GridHorizontalItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.grid_horizontal_item, parent, false);

        return new GridHorizontalViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(GridHorizontalViewHolder holder, int position) {
        holder.setItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class GridHorizontalViewHolder extends RecyclerView.ViewHolder {

        GridHorizontalItemBinding binding;

        public GridHorizontalViewHolder(GridHorizontalItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void setItem(final ItemModel data) {

            binding.imageView.setImageResource(data.getImage());
            binding.textView.setText(data.getName());

            //event is fired after you change rating
            binding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                    Toast.makeText(binding.getRoot().getContext(), String.valueOf(v), Toast.LENGTH_SHORT).show();
                    System.out.println("rating "+v);
                }
            });


        }


    }
}

