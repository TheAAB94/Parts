package us.asxpress.model;

public enum PartTypes {

    ALTERNATOR("Alternator"), FUELPUMP("Fuel Pump"), WATERPUMP("Water Pump"), STARTER("Starter");

    final String partType;

    PartTypes(final String partType) {
        this.partType = partType;
    }

   public String getValue(){
        return partType;
   }
}
