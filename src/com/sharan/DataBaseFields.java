package com.sharan;


import java.io.*;

import java.sql.*;


public class DataBaseFields {
    private static final String DB_NAME = "LMSDatabase.db";
    private static final String CONNECTION_STRING = "jdbc:sqlite:/home/sharan/javaprograms/projects/LMS/";
    private static final String TABLE_NAME = "librarianDetails ";
    private static final String TABLE_COLUMNS = "(ID INTEGER,Name TEXT,Password TEXT,Email TEXT,Address TEXT,City TEXT,Contact INTEGER)";
    private static final String TABLE_COLUMNS_INSERT = "(ID ,Name ,Password ,Email ,Address ,City ,Contact) ";

    private String ID = "0";
    private String Name;
    private String Password;
    private String Email;
    private String Address;
    private String City;
    private String Contact;

    private Connection connection = null;
    private Statement statement = null;

    private String idIncrementer() throws IOException {
        File file = new File("/home/sharan/javaprograms/projects/LMS/RowIdInserter.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String id;
        id=bufferedReader.readLine();
        int intID=Integer.parseInt(id);
        bufferedReader.close();
        intID=intID+1;
        String newId=String.valueOf(intID);
        this.ID=newId;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(newId, 0, newId.length());
        bufferedWriter.close();
        return newId;


    }
    public void idDecrementer() throws IOException{
            File file = new File("/home/sharan/javaprograms/projects/LMS/RowIdInserter.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String id;
            id=bufferedReader.readLine();
        int intID=Integer.parseInt(id);
        bufferedReader.close();
        intID=intID-1;
        String newId=String.valueOf(intID);
        this.ID=newId;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(newId, 0, newId.length());
        bufferedWriter.close();

    }

    public void initializeConnection()  {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING + DB_NAME);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + TABLE_COLUMNS);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addLibrarianDetails(String name, String password, String email, String address, String city, String contact) {
        this.Name = name;
        this.Password = password;
        this.Email = email;
        this.Address = address;
        this.City = city;
        this.Contact = contact;
        String id = this.ID;

        try {
            String idinc=idIncrementer();
            statement.execute("INSERT INTO " + TABLE_NAME + TABLE_COLUMNS_INSERT +
                    "VALUES(" + idinc + ",'" + name + "','" + password + "','" + email + "','" + address + "','" + city + "'," + contact + ")");


        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteLibrarianDetailsById(String id) {
//        this.ID=id;
        try {
            statement.execute("DELETE FROM " + TABLE_NAME + "WHERE ID = " + id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//    public void deleteLibrarianDetailsByName(String name){
////        this.Name=name;
//        try {
//            statement.execute("DELETE FROM "+TABLE_NAME+"IF EXISTS WHERE Name"+"="+name);
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }


    public void closeDatabaseConnection() {
        try {
            if (!connection.isClosed()) {
                statement.close();
                connection.close();
            } else {
                System.out.println("Error Closing DataBase");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public String getID() {
        return (ID);
    }

    public String getName(String id) {

        try {
            if (!connection.isClosed()) {
                ResultSet resultSet = statement.executeQuery("SELECT Name FROM " + TABLE_NAME + "WHERE ID = " + id);
                return resultSet.getString("Name");
            } else {
                return "Connection is Closed";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Exception";
        }
    }

}
