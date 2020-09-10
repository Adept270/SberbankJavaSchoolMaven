package com.jschool.Day1_OOP.TemperatureConverter;

public class Main {
    private static class Converter {

        public static double toFahrenheit(double celsius) {
            return celsius * (9.0 / 5) + 32;
        }

        public static double toKelvin(double celsius) {
            return celsius + 273.15 * 100;
        }

        public static double toRankin(double celsius) {
            return (celsius + 273.15) * (9.0 / 5) * 100;
        }

        public static double toDelisle(double celsius) {
            return (100 - celsius) * (3.0 / 2) * 1000;
        }

        public static double toNewton(double celsius) {
            return celsius * (33.0 / 100) * 100;
        }

        public static double toReaumur(double celsius) {
            return celsius * (4.0 / 5) * 100;
        }

        public static double toRomer(double celsius) {
            return celsius * (21.0 / 40) + 7.5 * 100;
        }
    }
}
