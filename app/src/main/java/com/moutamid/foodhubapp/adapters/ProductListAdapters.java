package com.moutamid.foodhubapp.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.foodhubapp.R;
import com.moutamid.foodhubapp.model.Product;

import java.util.List;

public class ProductListAdapters extends RecyclerView.Adapter<ProductListAdapters.ProductListView>{

    private Context mContext;
    private List<Product> productList;

    public ProductListAdapters(Context mContext, List<Product> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductListView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.product_custom_layout,parent,false);
        return new ProductListView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListView holder, int position) {
        Product product = productList.get(position);
        holder.prductTxt.setText(product.getProductName());
        holder.dateTxt.setText(product.getExpiryDate());
        Bitmap bitmap = BitmapFactory.decodeByteArray(product.getImgByte(),0,product.getImgByte().length);
        holder.imageView.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductListView extends RecyclerView.ViewHolder{

        public TextView prductTxt,dateTxt;
        private ImageView imageView;

        public ProductListView(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            prductTxt = itemView.findViewById(R.id.productName);
            dateTxt = itemView.findViewById(R.id.expiryDate);
        }
    }
}
