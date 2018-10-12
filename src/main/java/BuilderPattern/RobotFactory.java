package BuilderPattern;

public class RobotFactory implements RobotBuilder {

    private Robot robot;

    public RobotFactory() {
        this.robot = new Robot();
    }

    @Override
    public void buildRobotHead() {
        this.robot.setRobotHead("Big Head");

    }

    @Override
    public void buildRobotBody() {
        this.robot.setRobotBody("Small body");

    }

    @Override
    public void buildRobotLegs() {
        this.robot.setRobotLegs("Long legs");

    }

    @Override
    public void buildRobotArms() {
        this.robot.setRobotArms("Strong arms");

    }

    @Override
    public Robot getRobot() {
        return this.robot;
    }


}
