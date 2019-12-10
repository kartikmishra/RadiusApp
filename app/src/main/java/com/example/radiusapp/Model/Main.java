package com.example.radiusapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Main implements Parcelable {


    private String message;
    private Boolean success;
    private Data data;

    protected Main(Parcel in) {
        message = in.readString();
        byte tmpSuccess = in.readByte();
        success = tmpSuccess == 0 ? null : tmpSuccess == 1;
        data = in.readParcelable(Data.class.getClassLoader());
    }

    public static final Creator<Main> CREATOR = new Creator<Main>() {
        @Override
        public Main createFromParcel(Parcel in) {
            return new Main(in);
        }

        @Override
        public Main[] newArray(int size) {
            return new Main[size];
        }
    };

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(message);
        parcel.writeByte((byte) (success == null ? 0 : success ? 1 : 2));
        parcel.writeParcelable(data, i);
    }
}
