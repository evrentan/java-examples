package impl;

import service.Vehicle;

import java.util.Calendar;

public class VehicleImpl implements Vehicle {

  private int manufactureYear;
  private String model;

  public VehicleImpl(int manufactureYear, String model) {
    this.manufactureYear = manufactureYear;
    this.model = model;
  }

  @Override
  public int getAge() {
    return Calendar.getInstance().get(Calendar.YEAR) - this.manufactureYear;
  }

  @Override
  public String getModel() {
    return this.model;
  }
}
