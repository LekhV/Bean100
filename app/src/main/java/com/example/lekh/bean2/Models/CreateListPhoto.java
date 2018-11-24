package com.example.lekh.bean2.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class CreateListPhoto implements Parcelable {
private String imageUri;

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public CreateListPhoto(String imageUri) {
        this.imageUri = imageUri;
    }
    @Override
    public int describeContents() {
        return 0;
    }
    private CreateListPhoto(Parcel in) {

        this.imageUri = in.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public CreateListPhoto createFromParcel(Parcel in) {
            return new CreateListPhoto(in);
        }

        public CreateListPhoto[] newArray(int size) {
            return new CreateListPhoto[size];
        }
    };
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(imageUri);

    }
}
