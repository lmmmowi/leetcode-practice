# 183.从不订购的客户[https://leetcode-cn.com/problems/customers-who-never-order/]
SELECT Name AS Customers FROM Customers
WHERE NOT EXISTS (
    SELECT * FROM Orders WHERE CustomerId=Customers.Id
)