// 2383. 赢得比赛需要的最少训练时长[https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/]
#include <iostream>
#include <vector>

using namespace::std;

class Solution {
public:
    int minNumberOfHours(int initialEnergy, int initialExperience, vector<int>& energy, vector<int>& experience) {
        int train = 0;

        for (int i = 0; i < energy.size(); i++)
        {
            if (initialEnergy <= energy[i])
            {
                int gap = energy[i] + 1 - initialEnergy;
                train += gap;
                initialEnergy += gap;
            }
            initialEnergy -= energy[i];

            if (initialExperience <= experience[i])
            {
                int gap = experience[i] + 1 - initialExperience;
                train += gap;
                initialExperience += gap;
            }
            initialExperience += experience[i];
        }

        return train;
    }
};