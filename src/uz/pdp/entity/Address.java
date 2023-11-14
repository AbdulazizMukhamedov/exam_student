package uz.pdp.entity;

import java.io.Serializable;

public class Address implements Serializable {

    private Integer id;
    private String region;
    private String city;
    private String addressLine;

    public Address(Integer id, String region, String city, String addressLine) {
        this.id = id;
        this.region = region;
        this.city = city;
        this.addressLine = addressLine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", addressLine='" + addressLine + '\'' +
                '}';
    }
}
