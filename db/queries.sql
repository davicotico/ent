---
with recursive c as (
-------------
select p.id, p.parent_id, p.code, true as is_root
from ent.role_permission rp 
inner join ent."permission" p on (rp.id_permission = p.id)
where rp.id_role = 5 and p.application_id = 1
-------------

union all

select pr.id, pr.parent_id, pr.code, false as is_root
from ent."permission" as pr -- recursive
join c on c.id = pr. parent_id
)

select id, parent_id, code, is_root
from c
order by id asc
---

/*
select p.*
from ent.role_permission rp 
inner join ent."permission" p on (rp.id_permission = p.id)
where rp.id_role = 4 and p.application_id = 1
*/