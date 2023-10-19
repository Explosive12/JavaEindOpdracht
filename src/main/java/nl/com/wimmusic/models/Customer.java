package nl.com.wimmusic.models;

public class Customer {


    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Customer(int id, String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


}
