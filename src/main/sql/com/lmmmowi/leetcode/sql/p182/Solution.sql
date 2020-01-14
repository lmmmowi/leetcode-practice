# 182.查找重复的电子邮箱[https://leetcode-cn.com/problems/duplicate-emails/]
SELECT Email FROM Person GROUP BY Email HAVING COUNT(*)>1