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
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    List<Post> dataPost;
    Context context;
    private OnClickListener onClickListener;

    public PostAdapter(List<Post> dataPost, Context context, OnClickListener onClickListener) {
        this.dataPost = dataPost;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View item = layoutInflater.inflate(R.layout.item_post, viewGroup, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final com.androidnetworking.assandroidnetworking.model.Post post = dataPost.get(i);

        Picasso.with(context).load(post.getEmbedded().getWpFeaturedmedia().get(0).getMediaDetails().getSizes().getFull().getSourceUrl()).into(viewHolder.img_Item);


        viewHolder.img_Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClickListener(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataPost.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_Item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_Item = itemView.findViewById(R.id.imgPost);
        }


    }

}
