package com.androidnetworking.assandroidnetworking.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.assandroidnetworking.R;
import com.androidnetworking.assandroidnetworking.modelCategory.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private static ClickListener clickListener;
    List<Category> categories;
    Context context;

    public CategoryAdapter(List<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View item = layoutInflater.inflate(R.layout.item_cate, viewGroup, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Category category = categories.get(i);

        viewHolder.tvNameCategory.setText(category.getName());
        viewHolder.tvSoPhanTu.setText(category.getCount() + "");
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void setOnItemClickListener(CategoryAdapter.ClickListener clickListener) {
        CategoryAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img_Item;
        TextView tvNameCategory;
        TextView tvSoPhanTu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_Item = itemView.findViewById(R.id.imgCategory);
            tvNameCategory = itemView.findViewById(R.id.tvNameCategory);
            tvSoPhanTu = itemView.findViewById(R.id.tvSoPhanTu);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }
}
