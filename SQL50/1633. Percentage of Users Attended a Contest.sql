SELECT r.contest_id, ROUND(COUNT(u.user_id)/(SELECT COUNT(user_id) FROM Users)*100, 2) as percentage
FROM Users as u JOIN Register as r
ON u.user_id = r.user_id
GROUP BY r.contest_id
ORDER BY percentage DESC, contest_id ASC
;