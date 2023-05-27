package com.moutamid.foodhubapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.foodhubapp.R;
import com.moutamid.foodhubapp.RecipeWebScreen;
import com.moutamid.foodhubapp.model.Ingredients;
import com.moutamid.foodhubapp.model.Product;

import java.util.List;

public class IngredientListAdapters extends RecyclerView.Adapter<IngredientListAdapters.ProductListView>{

    private Context mContext;
    private List<Ingredients> productList;

    public IngredientListAdapters(Context mContext, List<Ingredients> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductListView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.ingredient_custom_layout,parent,false);
        return new ProductListView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListView holder, int position) {
        Ingredients ingredients = productList.get(position);
        holder.ingTxt.setText(ingredients.getName());
        if (ingredients.getQuantity() == 0){
            holder.quantityTxt.setVisibility(View.GONE);
        }else {
            holder.quantityTxt.setVisibility(View.VISIBLE);
            holder.quantityTxt.setText(String.valueOf(ingredients.getQuantity()));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse(ingredients.getLink());
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                try {
                    mContext.startActivity(webIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductListView extends RecyclerView.ViewHolder{

        public TextView ingTxt,quantityTxt;

        public ProductListView(@NonNull View itemView) {
            super(itemView);
            ingTxt = itemView.findViewById(R.id.ingredient);
            quantityTxt = itemView.findViewById(R.id.quantity);
        }
    }
}
