package com.lmmmowi.leetcode.p1604;

import java.util.*;

/**
 * @Author: lmmmowi
 * @Date: 2021/2/3
 * @Description: 1604.警告一小时内使用相同员工卡大于等于三次的人[https://leetcode-cn.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/]
 */
public class Solution {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            int timeByMinutes = convertToMinutes(keyTime[i]);
            List<Integer> timeList = map.computeIfAbsent(name, s -> new ArrayList<>());
            timeList.add(timeByMinutes);
        }

        List<String> result = new ArrayList<>();
        map.forEach((name, timeList) -> {
            Collections.sort(timeList);
            if (shouldAlert(timeList)) {
                result.add(name);
            }
        });

        Collections.sort(result);
        return result;
    }

    private boolean shouldAlert(List<Integer> timeList) {
        int size = timeList.size();
        for (int i = 2; i < size; i++) {
            int fromTime = timeList.get(i - 2);
            int endTime = timeList.get(i);
            if (endTime - fromTime <= 60) {
                return true;
            }
        }
        return false;
    }

    private int convertToMinutes(String time) {
        return (time.charAt(0) - '0') * 600
                + (time.charAt(1) - '0') * 60
                + (time.charAt(3) - '0') * 10
                + time.charAt(4) - '0';
    }
}
