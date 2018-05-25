package utils.ood.elevator;

import java.util.ArrayList;
import java.util.List;

public class RequestHandler {
    List<Request> requests;
    private static volatile RequestHandler instance = null;

    public static RequestHandler getInstance() {
        if (instance == null) {
            synchronized(RequestHandler.class) {
                if (instance == null) {
                    instance = new RequestHandler();
                }
            }
        }

        return instance;
    }

    private RequestHandler() {
        requests = new ArrayList<>();
    }


    public void addRequest(Request req) {
        synchronized(req) {
            requests.add(req);
        }
    }

    private Request getNextRequest() {
        int curentFloor = Elevator.getInstance().getCurrentFloor();
        int shortestdistance = Integer.MAX_VALUE;
        Request next = null;

        for (Request req: requests) {
            if (Math.abs(req.getTargetFloor() - curentFloor) < shortestdistance) {
                next = req;
            }
        }

        return next;
    }

    public void processRequest() {

        while (true) {
            Request req = getNextRequest();
            if (req != null) {
                while (Elevator.getInstance().getStatus() != 0);
                Elevator.getInstance().moveToFloor(req.getTargetFloor());
            }
        }

    }
}