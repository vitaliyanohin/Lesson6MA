public class Application {

  private static RobotConnection robotConnection;

  public static void main(String[] args) throws CloneNotSupportedException {

    Car carAudi = new Car("Audi", "red", "Buick V6 Series 2 3800");
    Car carAudiWithOtherEngine = carAudi.clone();
    carAudiWithOtherEngine.engineInTheCar.setEngine("AMC 4.08910");
    System.out.println(carAudi.toString());
    System.out.println(carAudiWithOtherEngine.toString());
  }
  public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) throws RobotConnectionException {
    int counter = 0;
    while (counter < 3) {
      try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
        System.out.println("System: Connection done! ");
        robotConnection.moveRobotTo(toX, toY);
        counter = 3;
      } catch (RobotConnectionException e) {
        System.out.println("System: Connection Attempt... №" + counter);
        counter++;
        if (counter == 3) {
          throw new RobotConnectionException("System: Connection Fail", e);
        }
      } finally {
        try {
          robotConnection.close();
        } catch (Exception ex) {
        }
      }
    }
  }
}
