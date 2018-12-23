package model;


import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", length = 6, nullable = false)
    int id;
    @Column(name="name")
    String name;
    @Column(name ="city")
    String city;

    public String getCity() {
        return city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return "User: \n ID: " + id +  "Name: " + name+" city " + city;
    }
}
