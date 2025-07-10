SELECT s.user_id, ROUND(AVG(IF(c.action='confirmed',1,0)),2) confirmation_rate
FROM Signups as s
LEFT JOIN Confirmations as c
ON s.user_id=c.user_id
GROUP BY s.user_id
; # 권한 테스트
