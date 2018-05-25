package utils.ood.elevator;

public class User{
    public void generateRequset(int targetFloor) {
        RequestHandler.getInstance().addRequest(new Request(targetFloor));
    }
}