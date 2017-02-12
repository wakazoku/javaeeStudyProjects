package beans;

import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Named
@RequestScoped
public class Bb {

    @NotNull
    private Integer number;

    @Size(max = 20, min = 1)
    private String name;

    @Size(max = 30, min = 1)
    private String mail;

    @Inject
    EmployeeDb db;

    @Inject
    transient Logger log;

    public String next() {
        create();
        return null;
    }

    public void create() {
        Employee emp = new Employee(number, name, mail);
        try {
            db.create(emp);
            clear();

        } catch (Exception e) {
            log.severe("★新規登録出来ない/" + number);
        }
    }
    
    public String update(){
        Employee employee = new Employee(number, name, mail);
        try {
            db.update(employee);
        } catch (Exception e) {
            log.fine("■" + number + " | " + e.getMessage());
        }
        return null;
    }
    
    public String find(){
        Employee employee = db.find(number);
        if (employee != null){
            this.number = employee.getNumber();
            this.name  = employee.getName();
            this.mail = employee.getMail();
        }
        return null;
    }
    
    // TODO:削除メソッドを実装する

    public void clear() {
        number = null;
        name = mail = null;
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
