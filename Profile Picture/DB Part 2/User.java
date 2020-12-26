package com.pf.tutorial;

public class User {

    private int id;
    private byte[] pp;

    public User(int id, byte[] pp) {
        this.id = id;
        this.pp = pp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getPp() {
        return pp;
    }

    public void setPp(byte[] pp) {
        this.pp = pp;
    }
}
