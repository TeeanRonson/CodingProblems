package BuilderPattern;

public class Robot implements RobotPlan {

    private String head;
    private String body;
    private String legs;
    private String arms;


    @Override
    public void setRobotHead(String head) {
        this.head = head;
    }

    public String getHead() {
        return this.head;
    }

    @Override
    public void setRobotBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }

    @Override
    public void setRobotLegs(String legs) {
        this.legs = legs;
    }

    public String getLegs() {
        return this.legs;
    }

    @Override
    public void setRobotArms(String arms) {
        this.arms = arms;
    }

    public String getArms() {
        return this.arms;
    }
}
