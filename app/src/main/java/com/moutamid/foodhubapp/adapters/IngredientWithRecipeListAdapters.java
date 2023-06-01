package com.moutamid.foodhubapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.foodhubapp.ProductRecipeDescription;
import com.moutamid.foodhubapp.R;
import com.moutamid.foodhubapp.model.Ingredients;

import java.util.List;

public class IngredientWithRecipeListAdapters extends RecyclerView.Adapter<IngredientWithRecipeListAdapters.ProductListView>{

    private Context mContext;
    private List<String> productList;

    public IngredientWithRecipeListAdapters(Context mContext, List<String> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductListView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.ingr_custom_layout,parent,false);
        return new ProductListView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListView holder, int position) {
        holder.prductTxt.setText(productList.get(position));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductListView extends RecyclerView.ViewHolder{

        public TextView prductTxt;

        public ProductListView(@NonNull View itemView) {
            super(itemView);
            prductTxt = itemView.findViewById(R.id.productName);

        }
    }
}
