package com.jschool.Day15_GOF.Refactor_1.Orientation;

public class Field {
    private final int[][] field;

    public Field(int length, int height) {
        this.field = new int[length][height];
    }

    public int[][] getField() {
        return field;
    }

    public boolean outOfField(Position position) {
        return position.getX() < 0 || position.getX() > field[0].length
                || position.getY() < 0 || position.getY() > field.length;
    }
}
