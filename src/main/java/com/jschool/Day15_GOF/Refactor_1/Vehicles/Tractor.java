package com.jschool.Day15_GOF.Refactor_1.Vehicles;

import com.jschool.Day15_GOF.Refactor_1.Controller.Controller;
import com.jschool.Day15_GOF.Refactor_1.Orientation.Field;
import com.jschool.Day15_GOF.Refactor_1.Orientation.Directions.Direction;
import com.jschool.Day15_GOF.Refactor_1.Orientation.Position;

public class Tractor implements Vehicle {
    protected Position position;
    private final Field field;
    private Direction direction;

    public Tractor(Field field, Position position, Direction direction) {
        this.field = field;
        this.position = position;
        this.direction = direction;
    }

    @Override
    public Direction getOrientation() {
        return direction;
    }

    @Override
    public void setOrientation(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Field getField() {
        return field;
    }

    @Override
    public void move(Controller controller) {
        controller.changeDirection();
    }

    @Override
    public Position getPosition() {
        return this.position;
    }


}
