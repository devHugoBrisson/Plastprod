package com.hugobrisson.plastprod;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ListView;

import org.androidannotations.annotations.AfterInject;
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

    List<Product> productsName = new ArrayList<>();

    @ViewById(R.id.list_products)
    ListView listView;

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            configure();
        }
    };

    @AfterInject
    void inject() {
        NotifService_.intent(getApplication()).start();
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, new IntentFilter("Update"));
    }


    @AfterViews()
    void configure() {
        productsName.clear();
        productsName.add(new Product("Commodos"));
        productsName.add(new Product("Retroviseurs"));
        productsName.add(new Product("Vitres"));
        productsName.add(new Product("Parechocs"));
        listView.setAdapter(new ProductAdapter(productsName, getLayoutInflater()));
    }

    @ItemClick(R.id.list_products)
    void ProductsListItemClick(Product product) {
        startActivity(new Intent(this, DetailsActivity_.class).putExtra("product",product));
    }

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        super.onDestroy();
    }
}
