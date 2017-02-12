package beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Employee implements Serializable {

    @Id
    @NotNull
    private Integer number;
    private String name;
    private String mail;

    private Employee() {
    }

    ;
    
    public Employee(Integer number, String name, String mail) {
        this.number = number;
        this.name = name;
        this.mail = mail;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
