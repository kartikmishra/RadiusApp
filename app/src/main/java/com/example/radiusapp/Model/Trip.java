package com.example.radiusapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Trip implements Parcelable {

    private String from;
    private String to;
    private Integer from_time;
    private Integer to_time;
    private Cost cost;
    private Integer trip_duration_in_mins;

    protected Trip(Parcel in) {
        from = in.readString();
        to = in.readString();
        if (in.readByte() == 0) {
            from_time = null;
        } else {
            from_time = in.readInt();
        }
        if (in.readByte() == 0) {
            to_time = null;
        } else {
            to_time = in.readInt();
        }
        cost = in.readParcelable(Cost.class.getClassLoader());
        if (in.readByte() == 0) {
            trip_duration_in_mins = null;
        } else {
            trip_duration_in_mins = in.readInt();
        }
    }

    public static final Creator<Trip> CREATOR = new Creator<Trip>() {
        @Override
        public Trip createFromParcel(Parcel in) {
            return new Trip(in);
        }

        @Override
        public Trip[] newArray(int size) {
            return new Trip[size];
        }
    };

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getFromTime() {
        return from_time;
    }

    public void setFromTime(Integer fromTime) {
        this.from_time = fromTime;
    }

    public Integer getToTime() {
        return to_time;
    }

    public void setToTime(Integer toTime) {
        this.to_time = toTime;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public Integer getTripDurationInMins() {
        return trip_duration_in_mins;
    }

    public void setTripDurationInMins(Integer tripDurationInMins) {
        this.trip_duration_in_mins = tripDurationInMins;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(from);
        parcel.writeString(to);
        if (from_time == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(from_time);
        }
        if (to_time == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(to_time);
        }
        parcel.writeParcelable(cost, i);
        if (trip_duration_in_mins == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(trip_duration_in_mins);
        }
    }
}
