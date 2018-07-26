/** Oauth - populate the oauth_client_details table */
INSERT INTO `oauth_client_details` (`client_id`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`)
VALUES
('second', 'passwordforauthserver', 'read', 'authorization_code,password,refresh_token,implicit', 'http://localhost:8081/', '30', '1800', '{}', 'true')
ON DUPLICATE key UPDATE
client_secret = VALUES(`client_secret`),
scope = VALUES(`scope`),
authorized_grant_types = VALUES(`authorized_grant_types`),
access_token_validity = VALUES(`access_token_validity`),
additional_information = VALUES(`additional_information`);

INSERT INTO `oauth_example`.`account` (`id`, `password`, `username`) VALUES ('	1	', 'user', 'user')
ON DUPLICATE key UPDATE
password = VALUES(`password`),
username = VALUES(`username`);
