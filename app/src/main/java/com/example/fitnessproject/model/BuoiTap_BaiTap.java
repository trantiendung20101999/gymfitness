package com.example.fitnessproject.model;

import java.io.Serializable;

public class BuoiTap_BaiTap implements Serializable {

    private BuoiTap buoitap;
    private BaiTap baitap;

    public BuoiTap_BaiTap(BuoiTap buoitap, BaiTap baitap) {
        this.buoitap = buoitap;
        this.baitap = baitap;
    }

    public BuoiTap_BaiTap() {
    }

    public BuoiTap getBuoitap() {
        return buoitap;
    }

    public void setBuoitap(BuoiTap buoitap) {
        this.buoitap = buoitap;
    }

    public BaiTap getBaitap() {
        return baitap;
    }

    public void setBaitap(BaiTap baitap) {
        this.baitap = baitap;
    }
}
