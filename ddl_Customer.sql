CREATE TABLE customers
(
    id      INT AUTO_INCREMENT NOT NULL,
    name    VARCHAR(255)       NULL,
    email   VARCHAR(255)       NULL,
    phoneNo VARCHAR(255)       NULL,
    pan     VARCHAR(255)       NULL,
    CONSTRAINT pk_customers PRIMARY KEY (id)
);