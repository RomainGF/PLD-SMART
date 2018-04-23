package com.h4413.recyclyon.Connection;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.h4413.recyclyon.Model.Association;
import com.h4413.recyclyon.Utility.DownLoadImageTask;

import com.h4413.recyclyon.R;

public class ChooseAssociationRecyclerViewAdapter extends RecyclerView.Adapter<ChooseAssociationRecyclerViewAdapter.ViewHolder> {
    private Association[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTitle;
        public TextView mDescription;
        public ImageView mLogo;

        public ViewHolder(final View v) {
            super(v);
            mTitle = (TextView) itemView.findViewById(R.id.choose_association_view_title);
            mDescription = (TextView) itemView.findViewById(R.id.choose_association_view_description);
            mLogo = (ImageView) itemView.findViewById(R.id.choose_association_view_logo);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ChooseAssociationRecyclerViewAdapter(Association[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ChooseAssociationRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // create a new view
        View v = inflater.inflate(R.layout.choose_association_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTitle.setText(mDataset[position].nom);
        holder.mDescription.setText(mDataset[position].description);
        new DownLoadImageTask(holder.mLogo).execute(mDataset[position].url);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}