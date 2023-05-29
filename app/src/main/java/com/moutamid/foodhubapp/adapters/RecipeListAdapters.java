package com.moutamid.foodhubapp.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.foodhubapp.R;
import com.moutamid.foodhubapp.model.Product;
import com.moutamid.foodhubapp.model.Recipe;
import com.moutamid.foodhubapp.utils.DbBitmapUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecipeListAdapters extends RecyclerView.Adapter<RecipeListAdapters.ProductListView>{

    private Context mContext;
    private List<Recipe> productList;

    public RecipeListAdapters(Context mContext, List<Recipe> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductListView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recipe_custom_layout,parent,false);
        return new ProductListView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListView holder, int position) {
        Recipe product = productList.get(position);
        holder.recipeTxt.setText(product.getName());
        holder.despTxt.setText(product.getDescription());
        //Bitmap b1 = BitmapFactory.decodeByteArray(product.getImage(), 0, product.getImage().length);
        holder.imageView.setImageBitmap(product.getImage());
    }

    public Bitmap StringToBitMap(String encodedString){
        try{
            byte [] encodeByte = Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }
        catch(Exception e){
            e.getMessage();
            return null;
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductListView extends RecyclerView.ViewHolder{

        public TextView recipeTxt,despTxt;
        public ImageView imageView;

        public ProductListView(@NonNull View itemView) {
            super(itemView);
            recipeTxt = itemView.findViewById(R.id.recipeName);
            despTxt = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
