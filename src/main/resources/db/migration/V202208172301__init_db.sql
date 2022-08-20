CREATE TABLE IF NOT EXISTS sensors
(
    id          BIGSERIAL   NOT NULL,
    title       VARCHAR(30) NOT NULL,
    model       VARCHAR(15) NOT NULL,
    range_from  INTEGER     NOT NULL,
    range_to    INTEGER     NOT NULL,
    type        VARCHAR(30) NOT NULL,
    unit        VARCHAR(30),
    location    VARCHAR(40),
    description VARCHAR(200),
    PRIMARY KEY(id)
);