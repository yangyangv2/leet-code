package utils.ood.parkinglog;

public class Bus extends Vehicle {
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }
    /*********only check whether size fit***********************************/
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large;
    }

    public void print() {
        System.out.print("B");
    }
}