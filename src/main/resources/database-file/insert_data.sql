-- Air Company

INSERT INTO `synergy`.`air_company`(`id`,`company_type`,`founded_at`, `name`)
VALUES(1,  'Major',    '1999-04-11',   'Alaska Airlines');

INSERT INTO `synergy`.`air_company`(`id`,`company_type`,`founded_at`, `name`)
VALUES(2,  'Major',    '2000-08-06',   'FedEx Express');

INSERT INTO `synergy`.`air_company`(`id`,`company_type`,`founded_at`, `name`)
VALUES(3,  'National',    '2012-04-16',   'Kalitta Air');

INSERT INTO `synergy`.`air_company`(`id`,`company_type`,`founded_at`, `name`)
VALUES(4,  'National',    '1970-11-10',   'Ryan Air Services');

INSERT INTO `synergy`.`air_company`(`id`,`company_type`,`founded_at`, `name`)
VALUES(5,  'National',    '1980-10-04',   'Bering Air');

INSERT INTO `synergy`.`air_company`(`id`,`company_type`,`founded_at`, `name`)
VALUES(6,  'Regional',    '1997-03-20',   'Envoy Air');

INSERT INTO `synergy`.`air_company`(`id`,`company_type`,`founded_at`, `name`)
VALUES(7,  'Regional',    '2020-01-19',   'Horizon Air');


--  Airplane

INSERT INTO `synergy`.`airplane`(`id`, `created_at`,`factory_serial_number`,`flight_distance`,`fuel_capacity`, `name`, `type`, `aircompany_id`)
VALUES(1, '2020-01-12', 1111, 560, 120, 'Sirius', 'Cargo plane', 3);

INSERT INTO `synergy`.`airplane`(`id`, `created_at`,`factory_serial_number`,`flight_distance`,`fuel_capacity`, `name`, `type`, `aircompany_id`)
VALUES(2, '2019-02-10', 2222, 320, 80, 'Betelgeuse', 'Cargo plane', 3);

INSERT INTO `synergy`.`airplane`(`id`, `created_at`,`factory_serial_number`,`flight_distance`,`fuel_capacity`, `name`, `type`, `aircompany_id`)
VALUES(3, '2018-04-20', 3333, 1200, 300, 'Rigel', 'Cargo plane', 1);

INSERT INTO `synergy`.`airplane`(`id`, `created_at`,`factory_serial_number`,`flight_distance`,`fuel_capacity`, `name`, `type`, `aircompany_id`)
VALUES(4, '2006-08-08', 4444, 600, 150, 'Vega', 'Passenger', 4);

INSERT INTO `synergy`.`airplane`(`id`, `created_at`,`factory_serial_number`,`flight_distance`,`fuel_capacity`, `name`, `type`, `aircompany_id`)
VALUES(5, '2008-11-18', 5555, 400, 130, 'Pleiades', 'Passenger', 4);

INSERT INTO `synergy`.`airplane`(`id`, `created_at`,`factory_serial_number`,`flight_distance`,`fuel_capacity`, `name`, `type`, `aircompany_id`)
VALUES(6, '2018-07-01', 6666, 880, 420, 'Antares', 'Passenger', 4);

INSERT INTO `synergy`.`airplane`(`id`, `created_at`,`factory_serial_number`,`flight_distance`,`fuel_capacity`, `name`, `type`, `aircompany_id`)
VALUES(7, '2018-08-12', 7777, 630, 315, 'Procyon', 'Passenger', 5);

INSERT INTO `synergy`.`airplane`(`id`, `created_at`,`factory_serial_number`,`flight_distance`,`fuel_capacity`, `name`, `type`, `aircompany_id`)
VALUES(8, '2017-09-19', 8888, 250, 70, 'Achernar', 'Passenger', 6);


-- Flight

INSERT INTO `synergy`.`flight`
(`id`, `created_at`, `delay_started_at`, `departure_country`, `destination_country`, `distance`, `ended_at`,
 `estimated_flight_time`, `flight_status`, `air_company_id_id`, `airplane_id`)
VALUES
(1,'2021-04-01 10:31:49', '2021-04-01 23:31:49', 'USA', 'Germany', 120, '2021-04-01 16:31:49', '04:00:00', 'COMPLETED', 3, 1);

INSERT INTO `synergy`.`flight`
(`id`, `created_at`, `delay_started_at`, `departure_country`, `destination_country`, `distance`, `ended_at`,
 `estimated_flight_time`, `flight_status`, `air_company_id_id`, `airplane_id`)
VALUES
(2,'2021-04-01 10:31:49', '2021-04-01 23:31:49', 'Belgium', 'India', 90, '2021-04-01 17:31:49', '08:00:00', 'COMPLETED', 3, 2);

INSERT INTO `synergy`.`flight`
(`id`, `created_at`, `delay_started_at`, `departure_country`, `destination_country`, `distance`, `ended_at`,
 `estimated_flight_time`, `flight_status`, `air_company_id_id`, `airplane_id`)
VALUES
(3,'2021-04-01 10:31:49', '2021-04-01 23:31:49', 'Mongolia', 'Netherlands', 190, '2021-04-01 18:31:49', '07:00:00', 'COMPLETED', 4, 4);

INSERT INTO `synergy`.`flight`
(`id`, `created_at`, `delay_started_at`, `departure_country`, `destination_country`, `distance`, `ended_at`,
 `estimated_flight_time`, `flight_status`, `air_company_id_id`, `airplane_id`)
VALUES
(4,'2021-04-01 23:31:49', '2021-04-02 07:31:49', 'Turkey', 'Ukraine', 100, '2021-04-01 23:31:49', '09:00:00', 'ACTIVE', 4, 5);

INSERT INTO `synergy`.`flight`
(`id`, `created_at`, `delay_started_at`, `departure_country`, `destination_country`, `distance`, `ended_at`,
 `estimated_flight_time`, `flight_status`, `air_company_id_id`, `airplane_id`)
VALUES
(5,'2021-04-01 23:31:49', '2021-04-02 03:31:49', 'Zimbabwe', 'Germany', 200, '2021-04-01 23:31:49', '05:00:00', 'ACTIVE', 1, 3);
