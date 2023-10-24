package nl.com.wimmusic.models;

import java.io.Serializable;

public class User implements Serializable {

  private final int id;
  private final String userName;
  private final String password;
  private final String name;
  private UserRoles userRole;

  public User(int id, String userName, String password, String name) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.name = name;
    this.userRole = UserRoles.None;
  }
  public String getUserName() {
    return userName;
  }

  public String getPassword() {return password;}

  public String getName() {return name;}

  public UserRoles getUserRole() {
    return userRole;
  }

  public void setUserRole(UserRoles userRole) {
    this.userRole = userRole;
  }
}
