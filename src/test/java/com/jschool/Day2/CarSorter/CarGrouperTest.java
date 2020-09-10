package com.jschool.Day2.CarSorter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CarGrouperTest {

    @Test
    public void carGroupValid() {
        ArrayList<Car> cars = CarGrouper.list;

        HashMap<String, List<String>> carGroupMap = CarGrouper.carGroup(cars);
        assertFalse(carGroupMap.isEmpty());

        assertEquals(3, carGroupMap.size());

        System.out.print("Типы моделей: ");
        for (Map.Entry<String, List<String>> entry : carGroupMap.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }

        System.out.println();

        for (Map.Entry<String, List<String>> entry : carGroupMap.entrySet()) {
            System.out.print(entry.getKey() + ": ");

            for (String s : entry.getValue()) {
                System.out.print(s + " ");
            }

            System.out.println();
        }

    }

    @Test
    public void car() {
    }
}