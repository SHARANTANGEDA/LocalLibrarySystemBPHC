package com.sharan.admin.adminOptions.viewLibrarian;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataViewer {
    public SimpleStringProperty id = new SimpleStringProperty();
    public SimpleStringProperty name = new SimpleStringProperty();
    public SimpleStringProperty email = new SimpleStringProperty();
    public SimpleStringProperty address = new SimpleStringProperty();
    public SimpleStringProperty city = new SimpleStringProperty();
    public SimpleIntegerProperty contact = new SimpleIntegerProperty();


    public SimpleStringProperty idProperty() {
        return id;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public SimpleIntegerProperty contactProperty() {
        return contact;
    }


    public void setId(String id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public void setContact(int contact) {
        this.contact.set(contact);
    }
}
