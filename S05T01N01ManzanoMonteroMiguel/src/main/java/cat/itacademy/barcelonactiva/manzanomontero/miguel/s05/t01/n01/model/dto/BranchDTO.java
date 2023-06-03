package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n01.model.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchDTO {
    private int pk_branchID;
    private String name;
    private String country;
    private String branchType;

    private List<String> countries;


    public BranchDTO() {}


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
        this.branchType = isUE(country);
    }

    public String getBranchType() {
        return branchType;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
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
