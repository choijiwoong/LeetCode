# Write your MySQL query statement below
# state는 입출금 승인,실패를 나타낸다.
# 각 나라와 도시 별로 거래건수와 총량, 승인된 거래의 개수와 총량을 나타내라.
# Write your MySQL query statement below
SELECT 
    t1.month,
    t1.country,
    COUNT(*) as trans_count,
    SUM(IF(t2.state="approved", 1, 0)) as approved_count,
    SUM(t2.amount) as trans_total_amount,
    SUM(IF(t2.state="approved", t2.amount, 0)) as approved_total_amount
FROM(
    SELECT 
        DISTINCT DATE_FORMAT(t.trans_date, '%Y-%m') as month, 
        t.country
    FROM Transactions as t
    ORDER BY DATE_FORMAT(t.trans_date, '%Y-%m'), t.country
    ) as t1 LEFT JOIN Transactions as t2
ON (t1.month = DATE_FORMAT(t2.trans_date, '%Y-%m') AND t1.country=t2.country)
GROUP BY t1.month, t1.country
