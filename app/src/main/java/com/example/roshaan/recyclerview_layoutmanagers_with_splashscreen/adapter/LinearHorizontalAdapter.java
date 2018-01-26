package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.R;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.LinearHorizontalItemBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.ItemModel;

import java.util.List;

/**
 * Created by Roshaan on 1/26/2018.
 */

public class LinearHorizontalAdapter extends RecyclerView.Adapter<LinearHorizontalAdapter.LinearHorizontalViewHolder> {
    List<ItemModel> data;

    public LinearHorizontalAdapter(List<ItemModel> data) {
        this.data = data;
    }

    @Override
    public LinearHorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearHorizontalItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.linear_horizontal_item, parent, false);

        return new LinearHorizontalViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(LinearHorizontalViewHolder holder, int position) {
        holder.setItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class LinearHorizontalViewHolder extends RecyclerView.ViewHolder {

        LinearHorizontalItemBinding binding;

        public LinearHorizontalViewHolder(LinearHorizontalItemBinding binding) {
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
