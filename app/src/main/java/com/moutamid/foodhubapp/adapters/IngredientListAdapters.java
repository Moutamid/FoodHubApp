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
        Ingredients product = productList.get(position);
        holder.prductTxt.setText(product.getName());
        holder.imageView.setImageResource(product.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProductRecipeDescription.class);
                intent.putExtra("model",product);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductListView extends RecyclerView.ViewHolder{

        public TextView prductTxt;
        private ImageView imageView;

        public ProductListView(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            prductTxt = itemView.findViewById(R.id.productName);

        }
    }
}
