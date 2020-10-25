package com.jschool.Day15_GOF.Refactor_1.Orientation.Directions;

import com.jschool.Day15_GOF.Refactor_1.Orientation.Position;

public class South implements Direction {
    @Override
    public Direction turnClockwise() {
        return new West();
    }

    @Override
    public void moveOneCellForward(Position position) {
        position.setY(position.getY() - 1);
    }
}
