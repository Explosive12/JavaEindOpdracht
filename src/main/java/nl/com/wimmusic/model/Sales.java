package nl.com.wimmusic.model;

public class Sales extends User {

  public Sales(int id, String userName, String password, String name) {
    super(id, userName, password, name);
    this.setUserRole(UserRoles.Sales);
  }
}
