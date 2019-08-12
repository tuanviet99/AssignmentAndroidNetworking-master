package com.androidnetworking.assandroidnetworking.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidnetworking.assandroidnetworking.R;
import com.androidnetworking.assandroidnetworking.model.Post;

import java.util.ArrayList;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {
    private static ClickListener clickListener;
    ArrayList<Post> dataPost;
    Context context;

    public FavoritesAdapter(ArrayList<Post> dataPost, Context context) {
        this.dataPost = dataPost;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View item = layoutInflater.inflate(R.layout.item_post, viewGroup, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return dataPost.size();
    }

    public void setOnItemClickListener(FavoritesAdapter.ClickListener clickListener) {
        FavoritesAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img_Item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_Item = itemView.findViewById(R.id.imgPost);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }
}
