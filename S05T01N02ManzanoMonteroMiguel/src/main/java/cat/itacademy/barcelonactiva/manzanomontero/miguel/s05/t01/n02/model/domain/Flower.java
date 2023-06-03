package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n02.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_FlowerID;
    private String name;
    private String country;


    public Flower() {}

    public Flower(String name, String country) {
        this.name = name;
        this.country = country;
    }


    public int getPk_FlowerID() {
        return pk_FlowerID;
    }

    public void setPk_FlowerID(int pk_FlowerID) {
        this.pk_FlowerID = pk_FlowerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
