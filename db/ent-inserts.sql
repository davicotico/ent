
-- applications
INSERT INTO ent.application (code, "name", description, url, created_at, updated_at, last_user) VALUES('ENT', 'ENT PLATFORM', 'Authentication & Authorization Application', 'http://localhost', '2024-02-21 21:25:52.031', NULL, 'superadmin');

-- users
INSERT INTO ent."user" (username, password_salt, password_hash, email, is_valid_email, active, created_at, updated_at, last_user) VALUES('superadmin', '123', '123', 'support@davidticona.com', true, true, '2024-02-21 21:54:32.654', NULL, 'superadmin');

-- users - applications
INSERT INTO ent.application_user (application_id, user_id, created_at, updated_at, last_user) VALUES(1, 1, '2024-02-21 21:56:46.213', NULL, 'superadmin');

-- roles
INSERT INTO ent."role" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, NULL, 'root', 'root', '2024-02-21 21:27:23.796', NULL, 'superadmin');
INSERT INTO ent."role" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 1, 'CEO', 'CEO', '2024-02-21 21:27:23.796', NULL, 'superadmin');
INSERT INTO ent."role" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 2, 'Operations', 'Operations', '2024-02-21 21:27:23.796', NULL, 'superadmin');
INSERT INTO ent."role" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 2, 'Financial', 'Financial', '2024-02-21 21:27:23.796', NULL, 'superadmin');
INSERT INTO ent."role" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 2, 'IT', 'IT', '2024-02-21 21:27:23.796', NULL, 'superadmin');
INSERT INTO ent."role" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 4, 'Sakes', 'Sales', '2024-02-21 21:27:23.796', NULL, 'superadmin');
INSERT INTO ent."role" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 4, 'Marketing', 'Marketing', '2024-02-21 21:27:23.796', NULL, 'superadmin');
INSERT INTO ent."role" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 4, 'Payroll', 'Payroll', '2024-02-21 21:27:23.796', NULL, 'superadmin');
INSERT INTO ent."role" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 5, 'Network', 'Network', '2024-02-21 21:27:23.796', NULL, 'superadmin');
INSERT INTO ent."role" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 5, 'Security', 'Security', '2024-02-21 21:27:23.796', NULL, 'superadmin');
INSERT INTO ent."role" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 5, 'Admin', 'Admin', '2024-02-21 21:27:23.796', NULL, 'superadmin');

-- permissions
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, NULL, 'root', 'root', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 1, 'Money', 'Money', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 1, 'System', 'System', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 1, 'Reports', 'Reports', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 2, 'Order', 'Order', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 2, 'Transfer', 'Transfer', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 3, 'Rooms', 'Rooms', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 3, 'Users', 'Users', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 4, 'General', 'General', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 4, 'Financial', 'Financial', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 4, 'Security', 'Security', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 7, 'Server', 'Server', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 7, 'Vault', 'Vault', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 8, 'Add', 'Add', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 8, 'Edit', 'Edit', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 8, 'Pass Change', 'Pass Change', '2024-02-21 21:44:52.868', NULL, 'superadmin');
INSERT INTO ent."permission" (application_id, parent_id, code, "name", created_at, updated_at, last_user) VALUES(1, 8, 'Remove', 'Remove', '2024-02-21 21:44:52.868', NULL, 'superadmin');

-- roles - permissions
INSERT INTO ent.role_permission (id_role, id_permission, created_at, updated_at, last_user) VALUES(1, 1, '2024-02-21 22:02:23.154', NULL, 'superadmin');

-- users - roles
INSERT INTO ent.user_role (user_id, role_id, created_at, updated_at, last_user) VALUES(1, 1, '2024-02-21 22:04:11.383', NULL, 'superadmin');

