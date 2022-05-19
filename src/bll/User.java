package bll;

import javax.swing.table.DefaultTableModel;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String name;
    private UserType userType;

    public User(String name, String username, String password, UserType usertype) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.userType = usertype;
        this.id = new DeliveryService().getUsers().size() + 1;
    }

    public User(DeliveryService deliveryService, String name, String username, String password, UserType usertype) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.userType = usertype;

        this.id = deliveryService.getUsers().size() + 1;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + userType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", userType=" + userType +
                "}\n";
    }

}
