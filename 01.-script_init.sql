


CREATE SCHEMA `banco_x` ;

CREATE USER 'gestion_bancaria' IDENTIFIED BY 'gestion_bancaria';

GRANT ALL PRIVILEGES ON banco_x.* TO 'gestion_bancaria';

FLUSH PRIVILEGES;