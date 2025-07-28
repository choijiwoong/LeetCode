# Write your MySQL query statement below
# state는 입출금 승인,실패를 나타낸다.
# 각 나라와 도시 별로 거래건수와 총량, 승인된 거래의 개수와 총량을 나타내라.
# Write your MySQL query statement below
SELECT 
    DISTINCT DATE_FORMAT(t.trans_date, '%Y-%m') as month, 
    t.country,
    COUNT(*) as trans_count,
    SUM(IF(t.state="approved", 1, 0)) as approved_count,
    SUM(IF(t.state="approved", t.amount, 0)) as trans_total_amount
FROM Transactions as t
ORDER BY DATE_FORMAT(t.trans_date, '%Y-%m'), t.country
