package com.java.se7.string.recipes;

/**
 * Created by vf-root on 2/13/15.
 */
public class Language {

    private int order;
    private String code;
    private double quality = 1.0;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }
}
