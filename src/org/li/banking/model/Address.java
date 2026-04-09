package org.li.banking.model;

import java.util.Objects;

public class Address {
    private String houseNo;
    private String buildingName;
    private String streetName;
    private String city;
    private String district;
    private String state;
    private Integer pincode;

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(houseNo, address.houseNo) && Objects.equals(buildingName, address.buildingName) && Objects.equals(streetName, address.streetName) && Objects.equals(city, address.city) && Objects.equals(district, address.district) && Objects.equals(state, address.state) && Objects.equals(pincode, address.pincode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseNo, buildingName, streetName, city, district, state, pincode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNo='" + houseNo + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}


