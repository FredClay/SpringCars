DROP TABLE IF EXISTS `car` CASCADE;

CREATE TABLE `car` (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255),
    `year_est` INTEGER NOT NULL,
    `country` VARCHAR(255)
);