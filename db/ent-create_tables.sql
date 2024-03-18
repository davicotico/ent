CREATE SCHEMA IF NOT EXISTS ent;

/* ---------------------------------------------------------------------- */
/* Add tables                                                             */
/* ---------------------------------------------------------------------- */

/* ---------------------------------------------------------------------- */
/* Add table "ent.user"                                                   */
/* ---------------------------------------------------------------------- */

CREATE TABLE ent.user (
    id BIGSERIAL  NOT NULL,
    username CHARACTER VARYING(50),
    password_salt CHARACTER VARYING(255),
    password_hash CHARACTER VARYING(255),
    email CHARACTER VARYING(250),
    is_valid_email BOOLEAN,
    active BOOLEAN,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    last_user CHARACTER VARYING(50),
    CONSTRAINT PK_user PRIMARY KEY (id)
);

/* ---------------------------------------------------------------------- */
/* Add table "ent.application"                                            */
/* ---------------------------------------------------------------------- */

CREATE TABLE ent.application (
    id SERIAL  NOT NULL,
    application_key UUID,
    code CHARACTER VARYING(20)  NOT NULL,
    name CHARACTER VARYING(250),
    description TEXT,
    version CHARACTER VARYING(15),
    url CHARACTER VARYING(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    last_user CHARACTER VARYING(50),
    CONSTRAINT PK_application PRIMARY KEY (id)
);

CREATE UNIQUE INDEX IDX_application_1 ON ent.application (application_key);

/* ---------------------------------------------------------------------- */
/* Add table "ent.menu"                                                   */
/* ---------------------------------------------------------------------- */

CREATE TABLE ent.menu (
    id SERIAL  NOT NULL,
    application_id INTEGER  NOT NULL,
    code CHARACTER VARYING(20)  NOT NULL,
    name CHARACTER VARYING(50),
    content TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    last_user CHARACTER VARYING(50),
    CONSTRAINT PK_menu PRIMARY KEY (id)
);

/* ---------------------------------------------------------------------- */
/* Add table "ent.application_user"                                       */
/* ---------------------------------------------------------------------- */

CREATE TABLE ent.application_user (
    application_id INTEGER  NOT NULL,
    user_id BIGINT  NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    last_user CHARACTER VARYING(50),
    CONSTRAINT PK_application_user PRIMARY KEY (application_id, user_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "ent.permission"                                             */
/* ---------------------------------------------------------------------- */

CREATE TABLE ent.permission (
    id SERIAL  NOT NULL,
    application_id INTEGER,
    parent_id INTEGER,
    code CHARACTER VARYING(20),
    name CHARACTER VARYING(150),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    last_user CHARACTER VARYING(50),
    CONSTRAINT PK_permission PRIMARY KEY (id)
);

/* ---------------------------------------------------------------------- */
/* Add table "ent.role"                                                   */
/* ---------------------------------------------------------------------- */

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

/* ---------------------------------------------------------------------- */
/* Add table "ent.user_role"                                              */
/* ---------------------------------------------------------------------- */

CREATE TABLE ent.user_role (
    user_id BIGINT  NOT NULL,
    role_id INTEGER  NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    last_user CHARACTER VARYING(50),
    CONSTRAINT PK_user_role PRIMARY KEY (user_id, role_id)
);

/* ---------------------------------------------------------------------- */
/* Add table "ent.role_permission"                                        */
/* ---------------------------------------------------------------------- */

CREATE TABLE ent.role_permission (
    role_id INTEGER  NOT NULL,
    permission_id INTEGER  NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    last_user CHARACTER VARYING(50),
    CONSTRAINT PK_role_permission PRIMARY KEY (role_id, permission_id)
);

/* ---------------------------------------------------------------------- */
/* Add foreign key constraints                                            */
/* ---------------------------------------------------------------------- */

ALTER TABLE ent.role ADD CONSTRAINT application_role 
    FOREIGN KEY (application_id) REFERENCES ent.application (id);

ALTER TABLE ent.role ADD CONSTRAINT role_role 
    FOREIGN KEY (parent_id) REFERENCES ent.role (id);

ALTER TABLE ent.user_role ADD CONSTRAINT user_user_role 
    FOREIGN KEY (user_id) REFERENCES ent.user (id);

ALTER TABLE ent.user_role ADD CONSTRAINT role_user_role 
    FOREIGN KEY (role_id) REFERENCES ent.role (id);

ALTER TABLE ent.menu ADD CONSTRAINT application_menu 
    FOREIGN KEY (application_id) REFERENCES ent.application (id);

ALTER TABLE ent.application_user ADD CONSTRAINT application_application_user 
    FOREIGN KEY (application_id) REFERENCES ent.application (id);

ALTER TABLE ent.application_user ADD CONSTRAINT user_application_user 
    FOREIGN KEY (user_id) REFERENCES ent.user (id);

ALTER TABLE ent.permission ADD CONSTRAINT permission_permission 
    FOREIGN KEY (parent_id) REFERENCES ent.permission (id);

ALTER TABLE ent.permission ADD CONSTRAINT application_permission 
    FOREIGN KEY (application_id) REFERENCES ent.application (id);

ALTER TABLE ent.role_permission ADD CONSTRAINT role_role_permission 
    FOREIGN KEY (role_id) REFERENCES ent.role (id);

ALTER TABLE ent.role_permission ADD CONSTRAINT permission_role_permission 
    FOREIGN KEY (permission_id) REFERENCES ent.permission (id);
