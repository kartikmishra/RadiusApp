package com.example.radiusapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Profile implements Parcelable {


    private String first_name;
    private String middle_name;
    private String last_name;
    private String profile_image;
    private String city;
    private String Country;

    protected Profile(Parcel in) {
        first_name = in.readString();
        middle_name = in.readString();
        last_name = in.readString();
        profile_image = in.readString();
        city = in.readString();
        Country = in.readString();
    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getMiddleName() {
        return middle_name;
    }

    public void setMiddleName(String middleName) {
        this.middle_name = middleName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getProfileImage() {
        return profile_image;
    }

    public void setProfileImage(String profileImage) {
        this.profile_image = profileImage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(first_name);
        parcel.writeString(middle_name);
        parcel.writeString(last_name);
        parcel.writeString(profile_image);
        parcel.writeString(city);
        parcel.writeString(Country);
    }
}
