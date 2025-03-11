SELECT A1.machine_id, ROUND(AVG(A2.timestamp-A1.timestamp), 3) as processing_time
FROM Activity as A1 
JOIN Activity as A2
ON A1.process_id=A2.process_id
WHERE A1.process_id=A2.process_id and A1.machine_id=A2.machine_id 
    and A1.activity_type='start' and A2.activity_type='end'
GROUP BY machine_id;