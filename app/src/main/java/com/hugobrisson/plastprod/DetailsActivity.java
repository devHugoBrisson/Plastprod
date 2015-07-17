package com.hugobrisson.plastprod;

import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hugo on 22/05/2015.
 */
@EActivity(R.layout.activity_details)
public class DetailsActivity extends ActionBarActivity {

    List<String> listClient = new ArrayList<>();


    @Extra("product")
    Product product;

    @ViewById(R.id.photo_product)
    ImageView photo_product;

    @ViewById(R.id.product_name_detail)
    TextView productName_TV;

    @ViewById(R.id.desc)
    TextView desc_TV;

    @ViewById(R.id.number_sell)
    TextView numberSell_TV;

    @ViewById(R.id.number_stock)
    TextView numberStock_TV;

    @ViewById(R.id.list_command)
    ListView listViewCommand;

    @AfterViews()
    void configure() {
        productName_TV.setText(product.getmName());
        numberStock_TV.setText(String.valueOf(product.getmInStock()));
        listClient.add("Renault");
        listClient.add("Ford");
        listViewCommand.setAdapter(new CommandAdapter(listClient, getLayoutInflater()));
    }
}
