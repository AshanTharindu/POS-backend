package pos.mini.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotBlank;

public class User {

    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    @Indexed(unique = true)
    private String userName;

    @NotBlank
    @JsonIgnore
    private String password;

    public User(){};


    @Override
    public String toString() {
        return userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
