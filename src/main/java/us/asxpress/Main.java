package us.asxpress;

import us.asxpress.dao.Logic;
import us.asxpress.model.Model;
import us.asxpress.model.PartTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static us.asxpress.model.Vehicles.GMCSAVANA3500;

public class Main {
    public static void main(String[] args) {

        String login;
        String password;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter login");
            login = scanner.nextLine();
            System.out.println("Enter password");
            password = scanner.nextLine();
        }

        DBUtils.createTable(login, password);

        Model starter = new Model(GMCSAVANA3500, "This is Starter", 11256, PartTypes.STARTER);
        Model alternator = new Model(GMCSAVANA3500, "This is Alternator", 11257, PartTypes.ALTERNATOR);
        Model waterPump = new Model(GMCSAVANA3500, "This is Water Pump", 11258, PartTypes.WATERPUMP);

        List<Model> parts = new ArrayList<>();
        parts.add(starter);
        parts.add(alternator);
        parts.add(waterPump);

        /*Logic.addPart(starter, login, password);
        Logic.addPart(alternator, login, password);
        Logic.addPart(waterPump, login, password);*/

        List<Model> parts1 = Logic.fetchData(login, password);
        for(Model model : parts1){
            System.out.println(model);
        }
    }
}
