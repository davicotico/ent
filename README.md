# Ent
Ent is a Spring Boot Authentication &amp; Authorization Platform (NIST Level 2 RBAC)

## What is RBAC?

RBAC separates the concepts of Users, Roles and Permissions. Roles are defined in a system, then Permissions defined separately. Then the security administrator decides what role should be permitted to do what action, by assigning that role to the permission. Finally users are assigned to roles. The system does the rest. 

NIST Level 2 RBAC requires Roles and/or Permissions to be hierarchical, so that management of them can easily be handled in hierarchies.


## Execute the backend

1. Create the database `ent`
2. Execute the scripts: `/db/ent-create_tables.sql` and `/db/ent-inserts.sql`
3. Open the backend project `/src/backend/ent`
4. Set your database credentials in `src/main/resources/application.properties`
4. Run

## Endpoints

Open in Postman `docs\postman\ent.postman_collection.json`

## TODO

#### Applications

- [x] Get all applications
- [x] Create application
- [x] Update application
- [x] Delete application
- [x] Add user
- [x] Remove user

#### Users

- [x] Get all users (by applicationId)
- [x] Get all roles (by applicationId & userId)
- [x] Get all roles trees (by applicationId & userId)
- [x] Create user
- [x] Update user
- [x] Delete user
- [x] Add role
- [x] Remove role

#### Roles

- [x] Get all roles (by applicationId)
- [x] Get all roles tree (by applicationId)
- [x] Get all permissions (by applicationId & roleId)
- [x] Get all permissions trees (by applicationId & roleId)
- [x] Create role
- [x] Update role
- [x] Delete role
- [x] Add permission
- [x] Remove permission

#### Permissions

- [x] Get all permissions (by applicationId)
- [x] Get all permissions tree (by applicationId)
- [x] Create permission
- [x] Update permission
- [x] Delete permission
