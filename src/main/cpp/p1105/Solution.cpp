// 1105. 填充书架[https://leetcode.cn/problems/filling-bookcase-shelves/]
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution
{
public:
    int minHeightShelves(vector<vector<int>> &books, int shelfWidth)
    {
        int n = books.size();
        int dp[n + 1];
        int w, h;

        dp[0] = 0;
        for (int i = 1; i <= n; i++)
        {
            dp[i] = 99999999;
            w = h = 0;

            for (int j = i; j > 0; j--)
            {
                w += books[j - 1][0];
                if (w > shelfWidth)
                {
                    break;
                }

                h = max(h, books[j - 1][1]);
                dp[i] = min(dp[i], dp[j - 1] + h);
            }
        }

        return dp[n];
    }
};

int main(void)
{
    int arr[7][2] = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
    vector<vector<int>> books;
    for (int i = 0; i < 7; i++)
    {
        vector<int> vec;
        vec.push_back(arr[i][0]);
        vec.push_back(arr[i][1]);
        books.push_back(vec);
    }

    Solution solution;
    int result = solution.minHeightShelves(books, 4);
    cout << result << endl;
}