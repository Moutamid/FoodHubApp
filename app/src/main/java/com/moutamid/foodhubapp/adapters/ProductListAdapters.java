package com.moutamid.foodhubapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moutamid.foodhubapp.DBHandler;
import com.moutamid.foodhubapp.R;
import com.moutamid.foodhubapp.model.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    public void onBindViewHolder(@NonNull ProductListView holder, @SuppressLint("RecyclerView") int position) {
        Product product = productList.get(position);
        holder.prductTxt.setText(product.getProductName());
        holder.dateTxt.setText(product.getExpiryDate());

        Bitmap bitmap = BitmapFactory.decodeByteArray(product.getImgByte(),0,product.getImgByte().length);
        holder.imageView.setImageBitmap(bitmap);
        DBHandler dbHandler = new DBHandler(mContext);
        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.deleteProduct(product);
                productList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeRemoved(position,productList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductListView extends RecyclerView.ViewHolder{

        public TextView prductTxt,dateTxt;
        private ImageView imageView,deleteBtn;

        public ProductListView(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            prductTxt = itemView.findViewById(R.id.productName);
            dateTxt = itemView.findViewById(R.id.expiryDate);
            deleteBtn =  itemView.findViewById(R.id.delete);
        }
    }
}
