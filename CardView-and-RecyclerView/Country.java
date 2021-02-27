package com.pf.tutorial;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("code")
    private Integer code;
    @SerializedName("name")
    private String name;
    @SerializedName("capital")
    private String capital;
    @SerializedName("currency")
    private String currency;
    @SerializedName("flag")
    private String flag;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", currency='" + currency + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
