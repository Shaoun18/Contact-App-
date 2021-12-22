package com.seip.android.contactappb1.models;

import java.util.ArrayList;
import java.util.List;

public class MyContact {
    private String name;
    private String mobile;
    private String email;
    private String address;
    private String image;

    public MyContact(String name, String mobile, String email, String address, String image) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "MyContact{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public static List<MyContact> getContacts() {
        final List<MyContact> contacts = new ArrayList<>();
        contacts.add(new MyContact("Shaheen", "01711000000", "shaheen@gmail.com", "Mirpur 12, Dhaka", null));
        contacts.add(new MyContact("Shumon Khan", "01711000001", "sk@gmail.com", "Mirpur 11, Dhaka", null));
        contacts.add(new MyContact("Rubel Hassan", "01711000002", "rh@gmail.com", "Mirpur 10, Dhaka", null));
        contacts.add(new MyContact("Abida Sultana", "01711000003", "as@gmail.com", "Mirpur 14, Dhaka", null));
        return contacts;
    }
}
