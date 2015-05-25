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

    private List<String> listProducts;
    private LayoutInflater layoutInflater;

    public ProductAdapter(List<String> products, LayoutInflater inflater) {
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
        productName.setText(listProducts.get(position));

        return convertView;
    }
}
