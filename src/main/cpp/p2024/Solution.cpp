// 2024. 考试的最大困扰度[https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/]
#include <iostream>

using namespace::std;

class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        size_t n = answerKey.length();
        int result = 1;

        for (int i=0; i<2; i++) {
            char diffChar = i==0 ? 'T' : 'F';
            int left = 0, diffCount = 0;

            for (int right = 0; right < n; right++) {
                if (answerKey[right] == diffChar) {
                    diffCount++;
                }

                while (diffCount > k) {
                    if (answerKey[left++] == diffChar) {
                        diffCount--;
                    }
                }

                result = max(result, right - left + 1);
            }
        }

        return result;
    }
};