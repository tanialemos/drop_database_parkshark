-- TABLE POSTALCODE

INSERT INTO POSTALCODE(POSTALCODE_ID, POSTALCODE, POSTALCODE_LABEL)
VALUES (nextval('postalcode_seq'), '1000', 'Bruxelles');
INSERT INTO POSTALCODE(POSTALCODE_ID, POSTALCODE, POSTALCODE_LABEL)
VALUES (nextval('postalcode_seq'), '1030', 'Schaarbeek');
INSERT INTO POSTALCODE(POSTALCODE_ID, POSTALCODE, POSTALCODE_LABEL)
VALUES (nextval('postalcode_seq'), '1050', 'Ixelles');

-- TABLE ADDRESSES

INSERT INTO ADDRESSES(ADDRESS_ID, STREET_NAME, STREET_NUMBER, POSTALCODE_ID)
VALUES (nextval('addresses_seq'), 'Boulevard Anspach', '5', '1');

-- TABLE PERSON_DETAILS

INSERT INTO PERSON_DETAILS(PERSON_DETAILS_ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS_ID, MOBILE_PHONE)
VALUES (nextval('person_details_seq'), 'Peter', 'Parker', 'peter.parker@gmail.com', 1, 0032487545856);

-- TABLE MEMBER

INSERT INTO MEMBERS (MEMBER_ID, PERSON_DETAILS_ID, LICENSE_PLATE_NUMBER, ISSUING_COUNTRY, REGISTRATION_DATE)
VALUES (nextval('members_seq'), 1, '1-AAA-111', 'België', '2007-01-01');