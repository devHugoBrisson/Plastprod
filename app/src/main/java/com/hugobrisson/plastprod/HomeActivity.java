package com.hugobrisson.plastprod;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hugo on 21/05/2015.
 */
@EActivity(R.layout.activity_home)
public class HomeActivity extends ActionBarActivity {

    List<String> productsName = new ArrayList<>();

    @ViewById(R.id.list_products)
    ListView listView;

    @AfterViews()
    void configure() {
        productsName.add("Hugo Brisson");
        productsName.add("Rodrigue Tillard");
        listView.setAdapter(new ProductAdapter(productsName, getLayoutInflater()));
    }

    @ItemClick(R.id.list_products)
    void ProductsListItemClick(String productsName) {
        startActivity(new Intent(this,DetailsActivity_.class).putExtra("product", productsName));
    }
}
