SELECT st.student_id, st.student_name, ex.subject_name 
FROM Students as st
CROSS JOIN Examinations as ex;