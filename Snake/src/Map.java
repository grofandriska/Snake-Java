import java.util.ArrayList;
import java.util.List;

public class Map {

    private int size;

    private String name;

    private List<Integer> tiles;

    private List<Car> vehicles;

    public Map(int size, String name) {
        this.size = size;
        this.name = name;
        this.tiles = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        populateMap();
        vehicles.add(new Car("Ferrari", 1, 3, 3));
        vehicles.add(new Car("Lamborghini", 1, 1, 1));

    }

    public void populateMap() {
        for (int i = 0; i < size; i++) {
            for (int x = 0; x < size; x++) {
                tiles.add(1);
            }
        }
    }

    public void readVehiclesIntoMap() {
        for (Car carIndex : vehicles) {
            tiles.set((carIndex.getxPosition() - 1) * size + (carIndex.getyPosition() - 1), 0);
        }
    }

    public void drawMap() {
        readVehiclesIntoMap();

        System.out.println();
        int index = 0;
        for (Integer tileIndex : tiles) {
            if (index == size) {
                System.out.print("\n");
                index = 0;
            }
            if (tileIndex == 0) {
                System.out.print("O");
            }
            if (tileIndex == 1) {
                System.out.print("X");
            }
            if (tileIndex == 2) {
                System.out.print("V");
            }
            index++;
        }
    }


}
