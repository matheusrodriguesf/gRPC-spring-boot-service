CREATE TABLE IF NOT EXISTS TB_PERSON (
    PK_PERSON SERIAL PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL,
    AGE INT NOT NULL,
    EMAIL VARCHAR(100) NOT NULL
);