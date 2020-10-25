package com.jschool.Day15_GOF.Refactor_1.Vehicles;

import com.jschool.Day15_GOF.Refactor_1.Controller.Controller;
import com.jschool.Day15_GOF.Refactor_1.Orientation.Field;
import com.jschool.Day15_GOF.Refactor_1.Orientation.Directions.Direction;
import com.jschool.Day15_GOF.Refactor_1.Orientation.Position;

public interface Vehicle {
    void move(Controller controller);

    public Position getPosition();

    Direction getOrientation();

    void setOrientation(Direction direction);

    Field getField();
}
