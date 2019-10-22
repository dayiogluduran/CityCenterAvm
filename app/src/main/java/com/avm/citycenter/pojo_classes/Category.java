package com.avm.citycenter.pojo_classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Category implements Parcelable {
    private int icon;                                    //Kategori ikonu
    private String title;                                //Kategori adı
    private ArrayList<Store> storesInCategory;           //Kategoriye dahil olan mağazalar

    public Category(String title, int icon, ArrayList<Store> stores) {
        this.icon = icon;
        this.title = title;
        this.storesInCategory = stores;
    }

    public Category() {
    }

    protected Category(Parcel in) {
        icon = in.readInt();
        title = in.readString();
        storesInCategory = in.createTypedArrayList(Store.CREATOR);
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public ArrayList<Store> getStoresInCategory() {
        return storesInCategory;
    }

    public void setStoresInCategory(ArrayList<Store> storesInCategory) {
        this.storesInCategory = storesInCategory;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(icon);
        dest.writeString(title);
        dest.writeTypedList(storesInCategory);
    }
}
