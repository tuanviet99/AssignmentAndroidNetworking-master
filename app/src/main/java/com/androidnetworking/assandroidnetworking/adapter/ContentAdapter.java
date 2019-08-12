package com.androidnetworking.assandroidnetworking.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidnetworking.assandroidnetworking.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

    private Context context;
    private List<String> listLink;
    private OnClickListener onClickListener;

    public ContentAdapter(Context context, List<String> listLink, OnClickListener onClickListener) {
        this.context = context;
        this.listLink = listLink;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_content, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Picasso.with(context).load(listLink.get(i)).into(viewHolder.imgPost);

        viewHolder.imgPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClickListener(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listLink.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPost = itemView.findViewById(R.id.img_avtPost);
        }
    }
}
