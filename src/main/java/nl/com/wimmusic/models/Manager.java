package nl.com.wimmusic.models;


public class Manager extends User {

    public Manager(int id, String userName, String password, String name) {
        super(id, userName, password, name);
        this.setUserRole(UserRoles.Manager);
    }
}
