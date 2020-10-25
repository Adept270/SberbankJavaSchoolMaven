package com.jschool.Day15_GOF.Refactor_1.Controller;

import com.jschool.Day15_GOF.Refactor_1.Orientation.Directions.Direction;
import com.jschool.Day15_GOF.Refactor_1.Orientation.Position;
import com.jschool.Day15_GOF.Refactor_1.Exceptions.TractorInDitchException;
import com.jschool.Day15_GOF.Refactor_1.Vehicles.Vehicle;

public class MoveForwardTractorCommand implements Controller {

    private final Vehicle vehicle;

    public MoveForwardTractorCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void changeDirection() {
        Direction direction = vehicle.getOrientation();
        Position position = vehicle.getPosition();

        direction.moveOneCellForward(position);

        if (vehicle.getField().outOfField(position)) {
            throw new TractorInDitchException("Трансопортное средство вышло за пределы поля." +
                    "Измените направление движения!");
        }

    }
}
