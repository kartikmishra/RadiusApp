package com.example.radiusapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Stats implements Parcelable {


    private Integer rides;
    private Integer free_rides;
    private Credits credits;

    protected Stats(Parcel in) {
        if (in.readByte() == 0) {
            rides = null;
        } else {
            rides = in.readInt();
        }
        if (in.readByte() == 0) {
            free_rides = null;
        } else {
            free_rides = in.readInt();
        }
        credits = in.readParcelable(Credits.class.getClassLoader());
    }

    public static final Creator<Stats> CREATOR = new Creator<Stats>() {
        @Override
        public Stats createFromParcel(Parcel in) {
            return new Stats(in);
        }

        @Override
        public Stats[] newArray(int size) {
            return new Stats[size];
        }
    };

    public Integer getRides() {
        return rides;
    }

    public void setRides(Integer rides) {
        this.rides = rides;
    }

    public Integer getFreeRides() {
        return free_rides;
    }

    public void setFreeRides(Integer freeRides) {
        this.free_rides = freeRides;
    }

    public Credits getCredits() {
        return credits;
    }

    public void setCredits(Credits credits) {
        this.credits = credits;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (rides == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(rides);
        }
        if (free_rides == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(free_rides);
        }
        parcel.writeParcelable(credits, i);
    }
}
