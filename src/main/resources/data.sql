
-- CREATE TABLE DISTRICT(
--     ID LONG PRIMARY KEY NOT NULL;
--     NAME_DISTRICT VARCHAR(30);
--     VALUE_PER_SQUARE_METER DOUBLE;
-- );
-- CREATE TABLE ROOM;
-- CREATE TABLE PROPERTY;


INSERT INTO DISTRICT (NAME, VALUE_PER_SQUARE_METER) VALUES ('Osasco', 10000.0);

INSERT INTO ROOM (AREA, LENGTH, WIDTH, NAME) VALUES (0.0, 10.0, 12.0, 'sala');
INSERT INTO ROOM (AREA, LENGTH, WIDTH, NAME) VALUES (0.0, 10.0, 18.0, 'quarto');

INSERT INTO PROPERTY (NAME, DISTRICT_ID) VALUES ('casa1', 1);

