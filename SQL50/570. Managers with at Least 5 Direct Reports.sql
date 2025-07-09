SELECT e1.name
FROM Employee AS e1
JOIN (
    SELECT managerId
    FROM Employee
    WHERE managerId IS NOT NULL        -- managerId가 존재하는 경우만 집계
    GROUP BY managerId
    HAVING COUNT(*) >= 5               -- 부하 직원이 5명 이상인 경우만
) AS sub
ON e1.id = sub.managerId;              -- 매니저의 id와 sub쿼리의 managerId 매칭