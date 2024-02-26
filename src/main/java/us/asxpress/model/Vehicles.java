package us.asxpress.model;

public enum Vehicles {

    GMCSAVANA3500("GMC Savana 3500");

    final String vehicle;

    Vehicles(final String vehicle) {
        this.vehicle = vehicle;
    }

    public String getValue(){
        return vehicle;
    }
}
