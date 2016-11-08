package com.numbedme.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by User on 03.11.2016.
 */
@Entity
public class Client {

    @Id
    private int id;
    private String name;
    private String address;

    public Client() {
    }

    public Client(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
