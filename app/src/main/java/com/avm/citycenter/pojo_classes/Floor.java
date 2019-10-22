package com.avm.citycenter.pojo_classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Floor implements Parcelable {
    private String floor;                           //Kaçıncı kat olduğu ve kat ismi
    private ArrayList<Store> storesInFloor;         //Katta bulunan mağazalar

    public Floor(String floor, ArrayList<Store> storesInFloor) {
        this.floor = floor;
        this.storesInFloor = storesInFloor;
    }

    public Floor() {
    }

    protected Floor(Parcel in) {
        floor = in.readString();
        storesInFloor = in.createTypedArrayList(Store.CREATOR);
    }

    public static final Creator<Floor> CREATOR = new Creator<Floor>() {
        @Override
        public Floor createFromParcel(Parcel in) {
            return new Floor(in);
        }

        @Override
        public Floor[] newArray(int size) {
            return new Floor[size];
        }
    };

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public ArrayList<Store> getStoresInFloor() {
        return storesInFloor;
    }

    public void setStoresInFloor(ArrayList<Store> storesInFloor) {
        this.storesInFloor = storesInFloor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(floor);
        dest.writeTypedList(storesInFloor);
    }
}
