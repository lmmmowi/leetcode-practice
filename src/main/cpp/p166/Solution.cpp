// 166. 分数到小数[https://leetcode.cn/problems/fraction-to-recurring-decimal/]
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace::std;

class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = numerator;
        long denominatorLong = denominator;
        if (numeratorLong % denominatorLong == 0)
        {
            return std::to_string(numeratorLong / denominatorLong);
        }

        bool isNegative = (numeratorLong < 0) ^ (denominatorLong < 0);
        string result = isNegative ? "-" : "";

        numeratorLong = std::abs(numeratorLong);
        denominatorLong = std::abs(denominatorLong);
        result += std::to_string(numeratorLong / denominatorLong) + ".";
        numeratorLong = numeratorLong % denominatorLong * 10;

        int n = 0;
        string fractionPart = "";
        unordered_map<long, int> existReminder;
        while (numeratorLong > 0)
        {
            if (existReminder.count(numeratorLong))
            {
                int index = existReminder[numeratorLong];
                fractionPart = fractionPart.substr(0, index) + "(" + fractionPart.substr(index) + ")";
                break;
            }
            existReminder[numeratorLong] = n++;

            fractionPart += std::to_string(numeratorLong / denominatorLong);
            numeratorLong = numeratorLong % denominatorLong * 10;
        }


        return result + fractionPart;
    }
};