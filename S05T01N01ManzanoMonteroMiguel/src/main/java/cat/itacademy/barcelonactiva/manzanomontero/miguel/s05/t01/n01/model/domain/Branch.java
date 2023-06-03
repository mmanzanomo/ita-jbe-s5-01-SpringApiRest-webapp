package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n01.model.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int pk_branchID;
    String name;
    String country;


    public Branch() {}
    public Branch(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public int getPk_branchID() {
        return pk_branchID;
    }

    public void setPk_branchID(int pk_branchID) {
        this.pk_branchID = pk_branchID;
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
