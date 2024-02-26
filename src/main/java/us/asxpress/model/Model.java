package us.asxpress.model;

public class Model {

    private final Vehicles vehicleModel;
    private final String partDescription;
    private final int partNumber;
    private final PartTypes partType;

    public Model(Vehicles vehicleModel, String partDescription, int partNumber, PartTypes partType) {
        this.vehicleModel = vehicleModel;
        this.partDescription = partDescription;
        this.partNumber = partNumber;
        this.partType = partType;
    }

    public Vehicles getVehicleModel() {
        return vehicleModel;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public PartTypes getPartType() {
        return partType;
    }

    @Override
    public String toString() {
        return "Model{" +
                "vehicleModel=" + vehicleModel +
                ", partDescription='" + partDescription + '\'' +
                ", partNumber=" + partNumber +
                ", partType=" + partType +
                '}';
    }
}
