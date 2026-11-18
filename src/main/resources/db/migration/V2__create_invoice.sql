CREATE TABLE invoices(
id BIGSERIAL PRIMARY KEY,
service VARCHAR(256) NOT NULL,
client_name VARCHAR(256) NOT NULL,
total_sum NUMERIC(12,2) NOT NULL,
paid_sum NUMERIC(12,2) NOT NULL DEFAULT(0) ,
date_of_creation DATE NOT NULL,
date_expiration DATE NOT NULL,
status VARCHAR(256) NOT NULL,
freelancer_id BIGINT NOT NULL REFERENCES users(id),
client_id BIGINT REFERENCES users(id)
);