package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n03.model.dto;


public class FlowerDTO {
    private int pk_FlowerID;
    private String name;
    private String country;
    private String flowerType;


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
    }

    public String getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
    }
}
