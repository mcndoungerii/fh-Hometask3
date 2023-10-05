import java.util.ArrayList;
import java.util.List;

class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class CombustionEngine extends Engine {
    public CombustionEngine() {
        super("Combustion Engine");
    }
}

class ElectricEngine extends Engine {
    public ElectricEngine() {
        super("Electric Engine");
    }
}

class HybridEngine extends Engine {
    public HybridEngine() {
        super("Hybrid Engine");
    }
}

class Manufacture {
    private String name;
    private String country;

    public Manufacture(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}

abstract class Vehicle {
    private Manufacture manufacture;
    private Engine engine;

    public Vehicle(Manufacture manufacture, Engine engine) {
        this.manufacture = manufacture;
        this.engine = engine;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public Engine getEngine() {
        return engine;
    }

    public abstract void ShowCharacteristics();
}

class ICEV extends Vehicle {
    public ICEV(Manufacture manufacture, CombustionEngine engine) {
        super(manufacture, engine);
    }

    @Override
    public void ShowCharacteristics() {
        System.out.println("ICEV Characteristics:");
        System.out.println("Manufacture: " + getManufacture().getName());
        System.out.println("Country: " + getManufacture().getCountry());
        System.out.println("Engine Type: " + getEngine().getType());
    }
}

class BEV extends Vehicle {
    public BEV(Manufacture manufacture, ElectricEngine engine) {
        super(manufacture, engine);
    }

    @Override
    public void ShowCharacteristics() {
        System.out.println("BEV Characteristics:");
        System.out.println("Manufacture: " + getManufacture().getName());
        System.out.println("Country: " + getManufacture().getCountry());
        System.out.println("Engine Type: " + getEngine().getType());
    }
}

class HybridV extends Vehicle {
    public HybridV(Manufacture manufacture, HybridEngine engine) {
        super(manufacture, engine);
    }

    @Override
    public void ShowCharacteristics() {
        System.out.println("HybridV Characteristics:");
        System.out.println("Manufacture: " + getManufacture().getName());
        System.out.println("Country: " + getManufacture().getCountry());
        System.out.println("Engine Type: " + getEngine().getType());
    }
}

public class CarManager {
    public static void main(String[] args) {
        Manufacture manufacture1 = new Manufacture("Mercedes-Benz", "Germany");
        Manufacture manufacture2 = new Manufacture("Tesla", "USA");
        Manufacture manufacture3 = new Manufacture("Toyota", "Japan");

        CombustionEngine ce = new CombustionEngine();
        ElectricEngine ee = new ElectricEngine();
        HybridEngine he = new HybridEngine();

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new ICEV(manufacture1, ce));
        vehicles.add(new BEV(manufacture2, ee));
        vehicles.add(new HybridV(manufacture3, he));

        for (Vehicle vehicle : vehicles) {
            vehicle.ShowCharacteristics();
            System.out.println();
        }
    }
}
