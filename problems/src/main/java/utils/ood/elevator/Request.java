package utils.ood.elevator;

public class Request {

    private int targetFloor;
    Request (int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }
}
