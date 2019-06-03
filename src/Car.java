public class Car implements Cloneable {

  private String name;
  private String color;
  EngineInTheCar engineInTheCar;

  public Car(String name, String color, String setEngine) {
    this.name = name;
    this.color = color;
    this.engineInTheCar = new EngineInTheCar();
    engineInTheCar.setEngine(setEngine);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  protected Car clone() throws CloneNotSupportedException {
    Car car = (Car) super.clone();
    car.engineInTheCar = engineInTheCar.clone();
    return car;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder
            .append("Car name: ").append(getName()).append("\n")
            .append("Car color: ").append(getColor()).append("\n")
            .append("Car engine: ").append(engineInTheCar.getEngine());
    return String.valueOf(stringBuilder);
  }
}
