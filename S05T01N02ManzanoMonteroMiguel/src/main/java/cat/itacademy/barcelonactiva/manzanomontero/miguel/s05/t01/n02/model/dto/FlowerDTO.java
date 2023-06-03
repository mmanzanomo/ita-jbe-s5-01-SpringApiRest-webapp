package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n02.model.dto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlowerDTO {
    private int pk_FlowerID;
    private String name;
    private String country;
    private String flowerType;
    private List<String> countries;


    public FlowerDTO() {}


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
        this.flowerType = isUE(country);
    }

    public String getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
    }


    private String isUE(String country) {
        this.countries = new ArrayList<>(Arrays.asList(
                "Germany", "Austria", "Belgium", "Bulgaria", "Cyprus", "Croatia", "Denmark", "Slovakia",
                "Slovenia", "Spain", "Estonia", "Finland", "France", "Greece", "Hungary", "Ireland",
                "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland",
                "Portugal", "United Kingdom", "Czech Republic", "Romania", "Sweden"
        ));

        return (countries.contains(country)) ? "UE" : "Outside UE";
    }

}
