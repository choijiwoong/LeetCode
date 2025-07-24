# Write your MySQL query statement below
# 중복데이터 존재하며, 쿼리응답DB 테이블이다.
# position은 1~500, rating은 `~5이다. 1~2는 poor query로 분류한다.
# 계산해야하는 quality는 rating과 position의 평균 비율이다.
# 계산해야하는 poor_query_percentage는 rating이 3 미만인 쿼리의 비율이다.
# 결과 테이블은 query_name, quality, poor_query_percentage로 구성되어야 한다.
# 모든 비율은 소수점 2자리까지 출력한다.
# 순서상관없이 출력한다.
SELECT q.query_name, ROUND(AVG(q.rating/q.position),2) as quality, ROUND(SUM(IF(q.rating<3, 1, 0))/COUNT(q.rating)*100,2) as poor_query_percentage
FROM Queries as q
GROUP BY q.query_name
;