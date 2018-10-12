package BuilderPattern;

public class RobotEngineer {

    private RobotBuilder rf;

    public RobotEngineer(RobotBuilder rf) {
        this.rf = rf;
    }

    public Robot getRobot() {
        return this.rf.getRobot();
    }

    public void makeRobot() {

        this.rf.buildRobotArms();
        this.rf.buildRobotBody();
        this.rf.buildRobotHead();
        this.rf.buildRobotLegs();
    }


    public static void main(String[] args) {

        RobotBuilder factory = new RobotFactory();
        RobotEngineer engineer = new RobotEngineer(factory);


        engineer.makeRobot();
        System.out.println(engineer.getRobot().getHead());
        System.out.println(engineer.getRobot().getBody());
        System.out.println(engineer.getRobot().getLegs());
        System.out.println(engineer.getRobot().getArms());






    }


}
