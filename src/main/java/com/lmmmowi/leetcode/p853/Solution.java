package com.lmmmowi.leetcode.p853;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2022/5/9
 * @Description: 853. 车队[https://leetcode.cn/problems/car-fleet/]
 */
public class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        List<Car> cars = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Car car = new Car(position[i], speed[i]);
            cars.add(car);
        }
        cars.sort(Comparator.comparingInt((Car car) -> car.position).reversed());

        int fleetCount = 0;
        float fleetTime = 0;
        for (Car car : cars) {
            float time = 1f * (target - car.position) / car.speed;
            if (time > fleetTime) {
                fleetCount++;
                fleetTime = time;
            }
        }
        return fleetCount;
    }

    private class Car {
        private int position;
        private int speed;

        Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
}
