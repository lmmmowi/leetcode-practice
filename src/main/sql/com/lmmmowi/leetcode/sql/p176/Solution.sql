# 176.第二高的薪水[https://leetcode-cn.com/problems/second-highest-salary/]
SELECT (
    SELECT DISTINCT Salary FROM Employee
    ORDER BY Salary DESC LIMIT 1, 1
) AS SecondHighestSalary