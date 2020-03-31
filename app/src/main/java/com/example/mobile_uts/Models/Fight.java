package com.example.mobile_uts.Models;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Fight implements Parcelable {
    private String nama1, nama2;
    private String dojang1, dojang2;
    private int jml1, jml2;
    private Type type;

    private Uri img1, img2;

    public enum Type {
        EMPTY,
        MALE,
        FEMALE
    }
    public Fight(){

    }

    public Fight(String nama1, String nama2, String dojang1, String dojang2, int jml1, int jml2, Type type,Uri img1, Uri img2) {
        this.nama1 = nama1;
        this.nama2 = nama2;
        this.dojang1 = dojang1;
        this.dojang2 = dojang2;
        this.jml1 = jml1;
        this.jml2 = jml2;
        this.type = type;
        this.img1 = img1;
        this.img2 = img2;
    }

    public String getNama1() {
        return nama1;
    }

    public void setNama1(String nama1) {
        this.nama1 = nama1;
    }

    public String getNama2() {
        return nama2;
    }

    public void setNama2(String nama2) {
        this.nama2 = nama2;
    }

    public String getDojang1() {
        return dojang1;
    }

    public void setDojang1(String dojang1) {
        this.dojang1 = dojang1;
    }

    public String getDojang2() {
        return dojang2;
    }

    public void setDojang2(String dojang2) {
        this.dojang2 = dojang2;
    }

    public Uri getImg1() {
        return img1;
    }

    public void setImg1(Uri img1) {
        this.img1 = img1;
    }

    public Uri getImg2() {
        return img2;
    }

    public void setImg2(Uri img2) {
        this.img2 = img2;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getJml1() {
        return jml1;
    }

    public void setJml1(int jml1) {
        this.jml1 = jml1;
    }

    public int getJml2() {
        return jml2;
    }

    public void setJml2(int jml2) {
        this.jml2 = jml2;
    }

    public static final Creator<Fight> CREATOR = new Creator<Fight>() {
        @Override
        public Fight createFromParcel(Parcel in) {
            return new Fight(in);
        }

        @Override
        public Fight[] newArray(int size) {
            return new Fight[size];
        }
    };

    protected Fight(Parcel in) {
        this.nama1 = in.readString();
        this.nama2 = in.readString();
        this.dojang1 = in.readString();
        this.dojang2 = in.readString();
//        this.img1 = in.readB
        this.jml1 = in.readInt();
        this.jml2 = in.readInt();
        int tmpType = in.readInt();
        this.type = tmpType == -1 ? null : Type.values()[tmpType];
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama1);
        dest.writeString(this.nama2);
        dest.writeString(this.dojang1);
        dest.writeString(this.dojang2);
        dest.writeInt(this.jml1);
        dest.writeInt(this.jml2);
        dest.writeInt(this.type == null ? -1 : this.type.ordinal());
    }
}