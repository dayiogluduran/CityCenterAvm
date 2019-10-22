package com.avm.citycenter.pojo_classes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Campaign implements Parcelable {
    private String title;                       //Kampanya veya etkinliğin başlğı
    private String slogan;                      //Kampanya veya etkinliğin sloganı
    private String dateRange;                   //Kampanya veya etkinliğin geçerli olduğu tarihler
    private int image;                          //Kampanya veya etkinliğin görseli - Muhtemelen url'den indirileceği icin
    private boolean liked = false;              //Kampanya veya etkinlik favorilere eklenirse
    private Date publishDate;                   //Kampanya veya etkinliğin yayınlanma tarihi
    private String details;                     //Kampanya veya etkinliğin detayları
    private boolean campaign;                   //Kampanya mı yoksa etkinlik mi?

    public Campaign(String title, String slogan, String date,
                    int image, Date publishDate, String details, boolean campaignOrNot) {
        this.title = title;
        this.slogan = slogan;
        this.dateRange = date;
        this.image = image;
        this.publishDate = publishDate;
        this.details = details;
        this.campaign = campaignOrNot;
    }

    public Campaign() {
    }

    protected Campaign(Parcel in) {
        title = in.readString();
        slogan = in.readString();
        dateRange = in.readString();
        details = in.readString();
        image = in.readInt();
        liked = in.readByte() != 0;
        campaign = in.readByte() != 0;

    }

    public static final Creator<Campaign> CREATOR = new Creator<Campaign>() {
        @Override
        public Campaign createFromParcel(Parcel in) {
            return new Campaign(in);
        }

        @Override
        public Campaign[] newArray(int size) {
            return new Campaign[size];
        }
    };

    public boolean isCampaign() {
        return campaign;
    }

    public void setCampaign(boolean campaign) {
        this.campaign = campaign;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String date) {
        this.dateRange = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(slogan);
        dest.writeString(dateRange);
        dest.writeString(details);
        dest.writeInt(image);
        dest.writeByte((byte) (liked ? 1 : 0));
        dest.writeByte((byte) (campaign ? 1 : 0));

    }
}
