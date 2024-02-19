CREATE SCHEMA IF NOT EXISTS ent;

CREATE TABLE ent.application (
    id SERIAL  NOT NULL,
    code CHARACTER VARYING(20)  NOT NULL,
    name CHARACTER VARYING(250),
    description TEXT,
    url CHARACTER VARYING(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    last_user CHARACTER VARYING(50),
    CONSTRAINT PK_application PRIMARY KEY (id)
);

-- roles
CREATE TABLE ent.role (
    id SERIAL  NOT NULL,
    application_id INTEGER  NOT NULL,
    parent_id INTEGER,
    code CHARACTER VARYING(20),
    name CHARACTER VARYING(200),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    last_user CHARACTER VARYING(50),
    CONSTRAINT PK_role PRIMARY KEY (id)
);

ALTER TABLE ent.role ADD CONSTRAINT application_role 
    FOREIGN KEY (application_id) REFERENCES ent.application (id);
ALTER TABLE ent.role ADD CONSTRAINT role_role 
    FOREIGN KEY (parent_id) REFERENCES ent.role (id);
	
-- permissions
CREATE TABLE ent.permission (
    id SERIAL  NOT NULL,
    application_id INTEGER,
    parent_id INTEGER,
    code CHARACTER VARYING(20),
    name CHARACTER VARYING(150),
    path CHARACTER VARYING(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    last_user CHARACTER VARYING(50),
    CONSTRAINT PK_permission PRIMARY KEY (id)
);

ALTER TABLE ent.permission ADD CONSTRAINT permission_permission 
    FOREIGN KEY (parent_id) REFERENCES ent.permission (id);
ALTER TABLE ent.permission ADD CONSTRAINT application_permission 
    FOREIGN KEY (application_id) REFERENCES ent.application (id);
	
-- roles-permissions
CREATE TABLE ent.role_permission (
    id_role INTEGER  NOT NULL,
    id_permission INTEGER  NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    last_user CHARACTER VARYING(50),
    CONSTRAINT PK_role_permission PRIMARY KEY (id_role, id_permission)
);

ALTER TABLE ent.role_permission ADD CONSTRAINT role_role_permission 
    FOREIGN KEY (id_role) REFERENCES ent.role (id);
ALTER TABLE ent.role_permission ADD CONSTRAINT permission_role_permission 
    FOREIGN KEY (id_permission) REFERENCES ent.permission (id);