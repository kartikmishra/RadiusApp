package com.example.radiusapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Theme implements Parcelable {


    private String dark_colour;
    private String light_colour;

    protected Theme(Parcel in) {
        dark_colour = in.readString();
        light_colour = in.readString();
    }

    public static final Creator<Theme> CREATOR = new Creator<Theme>() {
        @Override
        public Theme createFromParcel(Parcel in) {
            return new Theme(in);
        }

        @Override
        public Theme[] newArray(int size) {
            return new Theme[size];
        }
    };

    public String getDarkColour() {
        return dark_colour;
    }

    public void setDarkColour(String darkColour) {
        this.dark_colour = darkColour;
    }

    public String getLightColour() {
        return light_colour;
    }

    public void setLightColour(String lightColour) {
        this.light_colour = lightColour;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(dark_colour);
        parcel.writeString(light_colour);
    }
}
