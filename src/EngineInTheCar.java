public class EngineInTheCar implements Cloneable {
  private String engine;

  public String getEngine() {
    return engine;
  }

  public void setEngine(String engine) {
    this.engine = engine;
  }

  @Override
  protected EngineInTheCar clone() throws CloneNotSupportedException {
    return (EngineInTheCar) super.clone();
  }
}
