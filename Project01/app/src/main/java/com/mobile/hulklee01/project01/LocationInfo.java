package com.mobile.hulklee01.project01;

import android.app.Application;

public class LocationInfo extends Application {
    private String name1, name2, name3;
    private Double latitude1, latitude2, latitude3;
    private Double longitude1, longitude2, longitude3;
    private int radius1, radius2, radius3;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public Double getLatitude1() {
        return latitude1;
    }

    public void setLatitude1(Double latitude1) {
        this.latitude1 = latitude1;
    }

    public Double getLatitude2() {
        return latitude2;
    }

    public void setLatitude2(Double latitude2) {
        this.latitude2 = latitude2;
    }

    public Double getLatitude3() {
        return latitude3;
    }

    public void setLatitude3(Double latitude3) {
        this.latitude3 = latitude3;
    }

    public Double getLongitude1() {
        return longitude1;
    }

    public void setLongitude1(Double longitude1) {
        this.longitude1 = longitude1;
    }

    public Double getLongitude2() {
        return longitude2;
    }

    public void setLongitude2(Double longitude2) {
        this.longitude2 = longitude2;
    }

    public Double getLongitude3() {
        return longitude3;
    }

    public void setLongitude3(Double longitude3) {
        this.longitude3 = longitude3;
    }

    public int getRadius1() {
        return radius1;
    }

    public void setRadius1(int radius1) {
        this.radius1 = radius1;
    }

    public int getRadius2() {
        return radius2;
    }

    public void setRadius2(int radius2) {
        this.radius2 = radius2;
    }

    public int getRadius3() {
        return radius3;
    }

    public void setRadius3(int radius3) {
        this.radius3 = radius3;
    }

    public void delete1() {
        this.name1 = null;
        this.latitude1 = null;
        this.longitude1 = null;
        this.radius1 = 0;
    }

    public void delete2() {
        this.name2 = null;
        this.latitude2 = null;
        this.longitude2 = null;
        this.radius2 = 0;
    }

    public void delete3() {
        this.name3 = null;
        this.latitude3 = null;
        this.longitude3 = null;
        this.radius3 = 0;
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", name3='" + name3 + '\'' +
                ", latitude1=" + latitude1 +
                ", latitude2=" + latitude2 +
                ", latitude3=" + latitude3 +
                ", longitude1=" + longitude1 +
                ", longitude2=" + longitude2 +
                ", longitude3=" + longitude3 +
                ", radius1=" + radius1 +
                ", radius2=" + radius2 +
                ", radius3=" + radius3 +
                '}';
    }
}
