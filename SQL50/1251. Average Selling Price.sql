# Write your MySQL query statement below
# Price에는 기간 별 변동되는 가격의 정보를 가지고 있다.
# Unitsold에는 물품이 결제된 날짜 정보를 가지고 있다.
# 판매된 제품 별 평균 가를 소수점 2자리 까지 출력하라
SELECT u.product_id, ROUND(SUM(p.price*u.units)/SUM(u.units), 2) average_price
FROM UnitsSold as u LEFT JOIN Prices as p
ON u.product_id=p.product_id
WHERE p.end_date>=u.purchase_date AND u.purchase_date>=p.start_date
GROUP BY u.product_id
;
