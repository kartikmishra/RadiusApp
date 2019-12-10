package com.example.radiusapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Credits implements Parcelable {


    private Integer value;
    private String currency;
    private String currency_symbol;

    protected Credits(Parcel in) {
        if (in.readByte() == 0) {
            value = null;
        } else {
            value = in.readInt();
        }
        currency = in.readString();
        currency_symbol = in.readString();
    }

    public static final Creator<Credits> CREATOR = new Creator<Credits>() {
        @Override
        public Credits createFromParcel(Parcel in) {
            return new Credits(in);
        }

        @Override
        public Credits[] newArray(int size) {
            return new Credits[size];
        }
    };

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencySymbol() {
        return currency_symbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currency_symbol = currencySymbol;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (value == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(value);
        }
        parcel.writeString(currency);
        parcel.writeString(currency_symbol);
    }
}
