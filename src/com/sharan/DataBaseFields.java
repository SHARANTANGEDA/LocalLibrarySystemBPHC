package com.sharan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Integer.parseInt;

public class DataBaseFields {
    private static final String DB_NAME="librarianDetails.db";
    private static final String CONNECTION_STRING="jdbc:sqlite:/home/sharan/javaprograms/projects/LMS/";
    private static final String TABLE_NAME="librarianDetails ";
    private static final String TABLE_COLUMNS="(ID INTEGER,Name TEXT,Password TEXT,Email TEXT,Address TEXT,City TEXT,Contact INTEGER)";
    private static final String TABLE_COLUMNS_INSERT="(ID ,Name ,Password ,Email ,Address ,City ,Contact) ";

    private String ID="0";
    private String Name;
    private String Password;
    private String Email;
    private String Address;
    private String City;
    private String Contact;

    private Connection connection=null;
    private Statement statement=null;

    private void idIncrementer(){
        String id;
        id=this.ID;
        int intid=Integer.parseInt(id);
        intid+=1;
        id=String.valueOf(intid);
        this.ID=id;
    }

    public void initializeConnection(){
        try{
            connection = DriverManager.getConnection(CONNECTION_STRING+DB_NAME);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+TABLE_COLUMNS);

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void addLibrarianDetails(String name,String password,String email,String address,String city,String contact){
        this.Name=name;
        this.Password=password;
        this.Email=email;
        this.Address=address;
        this.City=city;
        this.Contact=contact;
        String id=this.ID;

        try {
            statement.execute("INSERT INTO " + TABLE_NAME + TABLE_COLUMNS_INSERT+
                    "VALUES("+id+",'"+name+"','"+password+"','"+email+"','"+address+"','"+city+"',"+contact+")" );
            idIncrementer();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteLibrarianDetailsById(String id){
//        this.ID=id;
        try {
            statement.execute("DELETE FROM "+TABLE_NAME+"WHERE ID"+"="+id);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteLibrarianDetailsByName(String name){
//        this.Name=name;
        try {
            statement.execute("DELETE FROM "+TABLE_NAME+"IF EXISTS WHERE Name"+"="+name);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void closeDatabaseConnection(){
        try {
            if(!connection.isClosed()){
            statement.close();
            connection.close();
            }
            else {
                System.out.println("Error Closing DataBase");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

//    public DataBaseFields(String id,String name,String password,String email,String address,String city,String contact){
//        this.Name=name;
//        this.Password=password;
//        this.Email=email;
//        this.Address=address;
//        this.City=city;
//        this.Contact=contact;
//        this.ID=id;
//    }

    public String getID() {
        return (ID);
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public String getCity() {
        return City;
    }

    public String getContact() {
        return Contact;
    }
}
