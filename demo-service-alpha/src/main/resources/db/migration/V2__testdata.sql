INSERT INTO ALPHA.USERS (ID, USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, SALARY, AGE)
VALUES (1, 'user1', 'Bobo', 'Boboa', '$2a$04$Ye7/lJoJin6.m9sOJZ9ujeTgHEVM4VXgI2Ingpsnf9gXyXEXf/IlW', 3456, 33);
INSERT INTO ALPHA.USERS (ID, USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, SALARY, AGE)
VALUES (2, 'user2', 'John', 'Smith', '$2a$04$StghL1FYVyZLdi8/DIkAF./2rz61uiYPI3.MaAph5hUq03XKeflyW', 7823, 23);
INSERT INTO ALPHA.USERS (ID, USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, SALARY, AGE)
VALUES (3, 'user3', 'Juergen', 'Killer', '$2a$04$Lk4zqXHrHd82w5/tiMy8ru9RpAXhvFfmHOuqTmFPWQcUhBD8SSJ6W', 4234, 45);

INSERT INTO ALPHA.ROLE (ID, DESCRIPTION, NAME)
VALUES (4, 'ADMIN ROLE', 'ADMIN');
INSERT INTO ALPHA.ROLE (ID, DESCRIPTION, NAME)
VALUES (5, 'USER ROLE', 'USER');

INSERT INTO ALPHA.USER_ROLES (USER_ID, ROLE_ID)
VALUES (1, 4);
INSERT INTO ALPHA.USER_ROLES (USER_ID, ROLE_ID)
VALUES (2, 5);