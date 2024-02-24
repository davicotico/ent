---
with recursive c as (
select p.id, p.parent_id, p.code, p.name, true as is_root
from ent.role_permission rp 
inner join ent."permission" p on (rp.permission_id = p.id)
where rp.role_id = 5 and p.application_id = 1

union all

select pr.id, pr.parent_id, pr.code, pr.name, false as is_root
from ent."permission" as pr -- recursive
join c on c.id = pr. parent_id
)

select id, parent_id as parentId, code, name, is_root as isRoot
from c
order by id asc
---

/*
select p.*
from ent.role_permission rp 
inner join ent."permission" p on (rp.id_permission = p.id)
where rp.id_role = 4 and p.application_id = 1
*/