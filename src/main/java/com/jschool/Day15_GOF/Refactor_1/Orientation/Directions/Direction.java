package com.jschool.Day15_GOF.Refactor_1.Orientation.Directions;

import com.jschool.Day15_GOF.Refactor_1.Orientation.Position;

public interface Direction {
    Direction turnClockwise();

    void moveOneCellForward(Position position);
}
