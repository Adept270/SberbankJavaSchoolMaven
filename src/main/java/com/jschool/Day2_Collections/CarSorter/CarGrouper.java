package com.jschool.Day2_Collections.CarSorter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarGrouper {
    static ArrayList<Car> list = new ArrayList<>();

    static {
        list.add(new Car("Лада", "седан"));
        list.add(new Car("Лада", "хэтчбек"));
        list.add(new Car("Мерседес", "седан"));
        list.add(new Car("БМВ", "кроссовер"));
        list.add(new Car("Форд", "хэтчбек"));
        list.add(new Car("Пежо", "кроссовер"));
        list.add(new Car("Тойота", "седан"));
    }

    public static HashMap<String, List<String>> carGroup(List<Car> rowlist) {

        HashMap<String, List<String>> resultList = new HashMap<>();

        for (Car car : rowlist) {
            String carType = car.getType();

            if (!resultList.containsKey(carType)) {
                List<String> modelList = new ArrayList<>();
                modelList.add(car.getModel());
                resultList.put(carType, modelList);
            } else {
                List<String> tempList = resultList.get(carType);
                tempList.add(car.getModel());
                resultList.put(carType, tempList);
            }
        }

        return resultList;
    }
}
