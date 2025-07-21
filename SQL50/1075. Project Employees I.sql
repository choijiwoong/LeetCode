# Write your MySQL query statement below
# Project테이블은 프로젝트-직원id
# Employee테이블은 직원id-이름-연차
# 프로젝트 별 평균 연차를 구해라. 소수점 2자리까지
SELECT p.project_id, ROUND(AVG(e.experience_years),2) as average_years
FROM Project as p JOIN Employee as e
ON p.employee_id = e. employee_id
GROUP BY p.project_id
;