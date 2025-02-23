SELECT name FROM Customer WHERE id not in (SELECT distinct id FROM Customer WHERE referee_id=2);
