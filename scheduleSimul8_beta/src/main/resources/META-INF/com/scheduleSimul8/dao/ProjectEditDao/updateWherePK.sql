update m_project
set
 project_name = /* entity.projectName */'123'
,update_date = /* entity.updateDate */'20200501120000'
where 1=1
and project_id = /* entity.projectId */'123'