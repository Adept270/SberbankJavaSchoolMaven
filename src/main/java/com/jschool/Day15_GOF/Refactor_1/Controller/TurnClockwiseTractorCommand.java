package com.jschool.Day15_GOF.Refactor_1.Controller;

import com.jschool.Day15_GOF.Refactor_1.Vehicles.Vehicle;

public class TurnClockwiseTractorCommand implements Controller {

    private final Vehicle vehicle;

    public TurnClockwiseTractorCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void changeDirection() {
        vehicle.setOrientation(vehicle.getOrientation().turnClockwise());

    }
}
