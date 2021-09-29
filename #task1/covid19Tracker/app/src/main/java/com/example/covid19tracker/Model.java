package com.example.covid19tracker;

public class Model {

    String district;
    String active;
    String recovered;
    String deceased;
    String deltaactive;
    String deltarecovered;
    String deltadeceased;

    public Model(String district, String active, String recovered, String deceased, String deltaactive, String deltarecovered, String deltadeceased) {
        this.district = district;
        this.active = active;
        this.recovered = recovered;
        this.deceased = deceased;
        this.deltaactive = deltaactive;
        this.deltarecovered = deltarecovered;
        this.deltadeceased = deltadeceased;
    }

    public Model() {
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeceased() {
        return deceased;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }

    public String getDeltaactive() {
        return deltaactive;
    }

    public void setDeltaactive(String deltaactive) {
        this.deltaactive = deltaactive;
    }

    public String getDeltarecovered() {
        return deltarecovered;
    }

    public void setDeltarecovered(String deltarecovered) {
        this.deltarecovered = deltarecovered;
    }

    public String getDeltadeceased() {
        return deltadeceased;
    }

    public void setDeltadeceased(String deltadeceased) {
        this.deltadeceased = deltadeceased;
    }
}
