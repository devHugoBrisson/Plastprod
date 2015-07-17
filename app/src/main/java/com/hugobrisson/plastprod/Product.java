package com.hugobrisson.plastprod;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

/**
 * Created by hugo on 19/06/2015.
 */
public class Product implements Parcelable {
    private String mName;
    private int mInStock;

    public Product(String name) {
        this.mName = name;
        Random rd = new Random();
        int stock = rd.nextInt(100) + 1;
        this.mInStock = stock;

    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmInStock() {
        return mInStock;
    }

    // Parcelling part
    public Product(Parcel in) {
        String[] data = new String[2];

        in.readStringArray(data);
        this.mName = data[0];
        this.mInStock = Integer.parseInt(data[1]);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.mName, String.valueOf(this.mInStock)});
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
