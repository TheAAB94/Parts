package us.asxpress.dao;

import us.asxpress.DBUtils;
import us.asxpress.model.Model;
import us.asxpress.model.PartTypes;
import us.asxpress.model.Vehicles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logic {

    public static void addPart(Model part, String login, String password){
        try(Connection conn = DBUtils.connect("parts", login, password);
            Statement stmt = conn.createStatement()){
            String data = "INSERT INTO parts (car_model, part_description, part_number, part_type) VALUES " +
                    "(" +
                    "'" + part.getVehicleModel().getValue() + "'" + "," +
                    "'" + part.getPartDescription() + "'" + "," +
                    part.getPartNumber() + "," +
                    "'" + part.getPartType().getValue() + "'" +
                    ");";
            stmt.execute(data);
        } catch (SQLException e) {
            throw new RuntimeException("Problem during adding part to DB " + e);
        }
    }

    public static List<Model> fetchData(String login, String password){
        List<Model> parts = new ArrayList<>();
        String query = "SELECT * FROM parts";

        Map<String, Vehicles> vehiclesMap = new HashMap<>();
        for(Vehicles vehicle : Vehicles.values()){
            vehiclesMap.put(vehicle.getValue(), vehicle);
        }
        Map<String, PartTypes> partTypesMap = new HashMap<>();
        for(PartTypes partType : PartTypes.values()){
            partTypesMap.put(partType.getValue(), partType);
        }

        try(Connection conn = DBUtils.connect("parts", login, password);
        Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)){
            while(rs.next()){
                String vehType = rs.getString(2);
                String partDesc = rs.getString(3);
                int prtNum = rs.getInt(4);
                String partType = rs.getString(5);
                parts.add(new Model(vehiclesMap.get(vehType), partDesc, prtNum, partTypesMap.get(partType)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return parts;
    }
}
