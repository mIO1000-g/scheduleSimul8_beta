select
 row_number() over (order by m1.project_id) as no
,m1.project_id as projectId
,m1.project_name as projectName
from m_project m1
where 1=1
/*%if projectName != null && projectName != "" */
and m1.project_name like /* @prefix(projectName) */'あ%'
/*%end*/
order by
 m1.project_id