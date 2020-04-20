CREATE TABLE IF NOT EXISTS ads (
  id               BIGINT AUTO_INCREMENT PRIMARY KEY,
  description      VARCHAR(50)  NOT NULL,
  rating           FLOAT        NOT NULL,
  creation_date    DATE     NOT NULL,
  image_url        VARCHAR(250) NOT NULL
);