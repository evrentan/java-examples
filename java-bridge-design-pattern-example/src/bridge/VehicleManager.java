package bridge;

import service.Vehicle;

public class VehicleManager {

  public Vehicle vehicle;

  public int getAge() {
    return this.vehicle.getAge();
  }

  public String getModel() {
    return this.vehicle.getModel();
  }
}
