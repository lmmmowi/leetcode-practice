// 646. 最长数对链[https://leetcode.cn/problems/maximum-length-of-pair-chain/]
class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        sort(pairs.begin(), pairs.end(), [](const auto& a, const auto& b) {
            return a[1] < b[1];
        });

        int result = 0;
        int end = pairs[0][0] - 1;

        for (int i=0; i<pairs.size(); i++) {
            if (pairs[i][0] > end) {
                end = pairs[i][1];
               result++;
           }
        }
        return result;
    }
};