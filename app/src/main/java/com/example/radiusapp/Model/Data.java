package com.example.radiusapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Data implements Parcelable {


    private Profile profile;
    private Stats stats;
    private List<Trip> trips = null;
    private Theme theme;

    protected Data(Parcel in) {
        profile = in.readParcelable(Profile.class.getClassLoader());
        stats = in.readParcelable(Stats.class.getClassLoader());
        trips = in.createTypedArrayList(Trip.CREATOR);
        theme = in.readParcelable(Theme.class.getClassLoader());
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(profile, i);
        parcel.writeParcelable(stats, i);
        parcel.writeTypedList(trips);
        parcel.writeParcelable(theme, i);
    }
}
