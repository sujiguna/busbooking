package com.example.hp.susithra.AccountActivity;

import android.widget.EditText;

public class user {
    public String name,email,num,address;
    public user(){}
    public user(String name, String email, String num, String address){
        this.name=name;
        this.email=email;
        this.num=num;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
