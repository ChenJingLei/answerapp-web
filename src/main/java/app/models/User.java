package app.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cjl20 on 2015/10/19.
 */

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String account;
    private String password;
    private String name;
    private String email;
    private String tel;
    private int type;

    protected User() {
    }

    public User(String account, String password, String name, String email, String tel, int type) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
