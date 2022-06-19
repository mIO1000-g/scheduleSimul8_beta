select
distinct
 t1.title as key
,t1.title as value
from t_simulation_h t1
where 1=1
/*%if version != null && version != "" */
and t1.version = cast(/* version */1 as integer)
/*%end*/
order by
t1.title
