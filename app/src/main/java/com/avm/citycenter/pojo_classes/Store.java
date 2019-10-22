package com.avm.citycenter.pojo_classes;

import android.os.Parcel;
import android.os.Parcelable;

public class Store implements Parcelable {
    private int storeLogo;                          //Mağaza logosu
    private String storeName;                       //Mağaza adı
    private String storeFloor;                      //Mağazanın bulunduğu kat
    private String storePhoneNumber;                //Mağazanın telefon numarası
    private String storeMailAddress;                //Mağazanın mail adresi
    private String googleMapsUrl;                   //Mağazanın google maps url'i
    private String storeDetails;                    //Mağazanın açıklaması


    public Store(String storeName, String storeFloor, int storeLogo, String storePhoneNumber,
                 String storeMailAddress, String googleMapsUrl, String storeDetails) {
        this.storeLogo = storeLogo;
        this.storeName = storeName;
        this.storeFloor = storeFloor;
        this.storePhoneNumber = storePhoneNumber;
        this.storeMailAddress = storeMailAddress;
        this.googleMapsUrl = googleMapsUrl;
        this.storeDetails = storeDetails;
    }

    public Store() {
    }

    protected Store(Parcel in) {
        storeLogo = in.readInt();
        storeName = in.readString();
        storeFloor = in.readString();
        storePhoneNumber = in.readString();
        storeMailAddress = in.readString();
        googleMapsUrl = in.readString();
        storeDetails = in.readString();
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };

    public String getStoreDetails() {
        return storeDetails;
    }

    public void setStoreDetails(String storeDetails) {
        this.storeDetails = storeDetails;
    }

    public String getStorePhoneNumber() {
        return storePhoneNumber;
    }

    public void setStorePhoneNumber(String storePhoneNumber) {
        this.storePhoneNumber = storePhoneNumber;
    }

    public String getStoreMailAddress() {
        return storeMailAddress;
    }

    public void setStoreMailAddress(String storeMailAddress) {
        this.storeMailAddress = storeMailAddress;
    }

    public String getGoogleMapsUrl() {
        return googleMapsUrl;
    }

    public void setGoogleMapsUrl(String googleMapsUrl) {
        this.googleMapsUrl = googleMapsUrl;
    }

    public int getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(int storeLogo) {
        this.storeLogo = storeLogo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreFloor() {
        return storeFloor;
    }

    public void setStoreFloor(String storeFloor) {
        this.storeFloor = storeFloor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(storeLogo);
        dest.writeString(storeName);
        dest.writeString(storeFloor);
        dest.writeString(storePhoneNumber);
        dest.writeString(storeMailAddress);
        dest.writeString(googleMapsUrl);
        dest.writeString(storeDetails);
    }
}
