import dto.Vehicle;
import factory.VehicleFactory;

import java.util.Scanner;

public class FactoryMethodDesignPattern {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the vehicle type for washing (car, suv, pickup or motorcycle): ");
    final String vehicleType = scanner.next();
    scanner.close();

    VehicleFactory vehicleFactory = new VehicleFactory();

    try {
      Vehicle vehicle = vehicleFactory.getVehicleType(vehicleType.trim().toLowerCase());
      System.out.println(String.format("Price of washing %s is %s and the washing rate is %.2f"
          , vehicle.getClass().getSimpleName()
          , vehicle.calculateWashRate()
          , vehicle.getWashRate()));
    } catch (IllegalArgumentException exception) {
      System.out.println(exception.getMessage());
    }
  }
}