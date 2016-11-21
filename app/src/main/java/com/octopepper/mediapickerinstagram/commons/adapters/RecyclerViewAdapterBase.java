package com.octopepper.mediapickerinstagram.commons.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerViewAdapterBase<T, V extends View> extends RecyclerView.Adapter<ViewWrapper<V>> {

    protected List<T> mItems = new ArrayList<>();

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public final ViewWrapper<V> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewWrapper<>(onCreateItemView(parent, viewType));
    }

    protected abstract V onCreateItemView(ViewGroup parent, int viewType);

    public void setItems(List<T> items) {
        if (items != null) {
            mItems = items;
            notifyDataSetChanged();
        }
    }

    public void addItems(List<T> items, int position) {
        if (items != null) {
            mItems.addAll(position, items);
            notifyItemRangeInserted(position, items.size());
        }
    }

    public void addItem(T item, int position) {
        if (item != null) {
            mItems.add(position, item);
            notifyItemInserted(position);
        }
    }

    public void removeItem(T item) {
        if (item != null) {
            int position = mItems.indexOf(item);
            mItems.remove(item);
            notifyItemRemoved(position);
        }
    }

    public void removeItems(List<T> items) {
        if (items != null) {
            mItems.removeAll(items);
            notifyItemRangeRemoved(mItems.indexOf(items.get(0)), items.size());
        }
    }

    public void removeRangeItem(int firstPosition) {
        int size = mItems.size();
        List<T> removes = new ArrayList<>();
        for (int i = firstPosition; i < size; i++) {
            removes.add(mItems.get(i));
        }
        mItems.removeAll(removes);
        notifyItemRangeRemoved(firstPosition, size);
    }

    public void clearItems() {
        int size = mItems.size();
        mItems.clear();
        notifyItemRangeRemoved(0, size);
    }

    public T getItemAtPosition(int position) {
        return mItems.get(position);
    }


}
