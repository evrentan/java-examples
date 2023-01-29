package factory;

import dto.*;

public class VehicleFactory {
  public Vehicle getVehicleType(String vehicleType) {
    return switch (vehicleType) {
      case "car" -> new Car();
      case "suv" -> new Suv();
      case "pickup" -> new Pickup();
      case "motorcycle" -> new Motorcycle();
      default -> throw new IllegalArgumentException("Wrong Vehicle Type !!!");
    };
  }
}
