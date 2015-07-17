package com.hugobrisson.plastprod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hugo on 21/05/2015.
 */
public class ProductAdapter extends BaseAdapter {

    private List<Product> listProducts;
    private LayoutInflater layoutInflater;

    public ProductAdapter(List<Product> products, LayoutInflater inflater) {
        listProducts = products;
        layoutInflater = inflater;

    }

    @Override
    public int getCount() {
        return listProducts.size();
    }

    @Override
    public Object getItem(int position) {
        return listProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.list_item, null);
        TextView productName = (TextView) convertView.findViewById(R.id.product_name);
        TextView productStock = (TextView) convertView.findViewById(R.id.number);
        productName.setText(listProducts.get(position).getmName());
        productStock.setText((String.valueOf(listProducts.get(position).getmInStock())));

        return convertView;
    }
}
