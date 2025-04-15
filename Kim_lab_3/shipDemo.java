import java.util.ArrayList;

public class shipDemo {
    public static void main(String[] args) {
        Ship[] ships = new Ship[3];
        ships[0] = new CruiseShip("Madison Queen", "2002", 5000);
        ships[1] = new CargoShip("Man of War", "2020", 100000);
        ships[2] = new CargoShip("Liberty 241", "1999", 200000);

        System.out.println("Displaying ships using display() method: ");
        for (Ship ship: ships) {
            ship.display();
        }
        ArrayList<Ship> shipList = new ArrayList<>();
        shipList.add(new CruiseShip("Union", "2023", 3000));
        shipList.add(new CargoShip("15 Duck", "2022", 300000));
        System.out.println("Displaying ships using toString() method: ");
        for (Ship ship: shipList) {
            System.out.println(ship.toString());
        }

        CruiseShip copyCruiseShip = new CruiseShip((CruiseShip) ships[0]);
        CargoShip copyCargoShip = new CargoShip((CargoShip) ships[1]);
        System.out.println("Testing copy constructors: ");
        copyCruiseShip.display();
        copyCargoShip.display();


    }
}
