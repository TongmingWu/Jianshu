package com.tongming.jianshu.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tongming on 2016/7/2.
 */
public class LoginUser implements Parcelable {
    private String user_id;
    private String user_slug;
    private int code;
    private UserLatest latest;

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_slug(String user_slug) {
        this.user_slug = user_slug;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setLatest(UserLatest latest) {
        this.latest = latest;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_slug() {
        return user_slug;
    }

    public int getCode() {
        return code;
    }

    public UserLatest getLatest() {
        return latest;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.user_id);
        dest.writeString(this.user_slug);
        dest.writeInt(this.code);
        dest.writeParcelable(this.latest, flags);
    }

    public LoginUser() {
    }

    protected LoginUser(Parcel in) {
        this.user_id = in.readString();
        this.user_slug = in.readString();
        this.code = in.readInt();
        this.latest = in.readParcelable(UserLatest.class.getClassLoader());
    }

    public static final Parcelable.Creator<LoginUser> CREATOR = new Parcelable.Creator<LoginUser>() {
        @Override
        public LoginUser createFromParcel(Parcel source) {
            return new LoginUser(source);
        }

        @Override
        public LoginUser[] newArray(int size) {
            return new LoginUser[size];
        }
    };
}
