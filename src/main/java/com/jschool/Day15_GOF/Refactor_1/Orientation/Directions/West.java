package com.jschool.Day15_GOF.Refactor_1.Orientation.Directions;

import com.jschool.Day15_GOF.Refactor_1.Orientation.Position;

public class West implements Direction {
    @Override
    public Direction turnClockwise() {
        return new North();
    }

    @Override
    public void moveOneCellForward(Position position) {
        position.setX(position.getX() - 1);
    }
}
