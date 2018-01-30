package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.R;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.LinearVerticalItemBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.databinding.StaggeredItemBinding;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.ItemModel;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.StaggeredItem;

import java.util.List;

/**
 * Created by Roshaan on 1/30/2018.
 */

public class MultipleViewTypesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //constants
    public static final int ITEM_MODEL = 0;
    public static final int STAGGERED_ITEM = 1;

    List<Object> data;

    public MultipleViewTypesAdapter(List<Object> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {

            case MultipleViewTypesAdapter.ITEM_MODEL:
                LinearVerticalItemBinding linearVerticalBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.linear_vertical_item, parent, false);
                return new LinearVerticalViewHolder(linearVerticalBinding);

            case MultipleViewTypesAdapter.STAGGERED_ITEM:
                StaggeredItemBinding staggeredBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.staggered_item, parent, false);
                return new StaggeredViewHolder(staggeredBinding);

            default:
                   return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)){
            case MultipleViewTypesAdapter.ITEM_MODEL:
                ((LinearVerticalViewHolder)holder).setItem((ItemModel)data.get(position));
                break;
            case MultipleViewTypesAdapter.STAGGERED_ITEM:
                ((StaggeredViewHolder)holder).setItem((StaggeredItem)data.get(position));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (data.get(position) instanceof ItemModel) {
            return MultipleViewTypesAdapter.ITEM_MODEL;
        } else if (data.get(position) instanceof StaggeredItem) {
            return MultipleViewTypesAdapter.STAGGERED_ITEM;
        }

        return -1;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}


