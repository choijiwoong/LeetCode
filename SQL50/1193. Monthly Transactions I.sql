# Write your MySQL query statement below
SELECT 
    DATE_FORMAT(t.trans_date, '%Y-%m') as month
    , t.country
FROM Transactions as t
ORDER BY DATE_FORMAT(t.trans_date, '%Y-%m'), t.country