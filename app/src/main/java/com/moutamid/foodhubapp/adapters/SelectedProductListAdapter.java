package com.moutamid.foodhubapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.moutamid.foodhubapp.R;
import com.moutamid.foodhubapp.listener.ItemClickListener;
import com.moutamid.foodhubapp.model.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SelectedProductListAdapter extends BaseAdapter implements Filterable {

    private Context mContext;
    private List<Product> productList;
    private ItemClickListener itemClickListener;

    public SelectedProductListAdapter(Context mContext, List<Product> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.custom_layout, parent, false);
        TextView textView = convertView.findViewById(R.id.productName);
        CheckBox checkBox = convertView.findViewById(R.id.checkbox);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null){
                    itemClickListener.onItemClick(position,v);
                }
            }
        });

        Product model = productList.get(position);
        textView.setText(model.getProductName());


        return convertView;
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Product> filterList = new ArrayList<>();

            if (charSequence.toString().isEmpty()) {
                filterList.addAll(productList);
            } else {
                for (Product data : productList) {
                    if (data.getProductName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filterList.add(data);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filterList;

            return filterResults;

        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            productList.clear();
            productList.addAll((Collection<? extends Product>) filterResults.values);
            notifyDataSetChanged();

        }
    };

}