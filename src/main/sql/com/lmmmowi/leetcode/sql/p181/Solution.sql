# 181.超过经理收入的员工[https://leetcode-cn.com/problems/employees-earning-more-than-their-managers/]
SELECT E1.Name AS Employee FROM Employee E1
WHERE EXISTS (
    SELECT * FROM Employee E2 WHERE E1.ManagerId=E2.Id AND E1.Salary>E2.Salary
)