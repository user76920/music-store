CREATE TABLE ACCOUNT
(
  ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
  VALUE DOUBLE
);

CREATE TABLE PLAYLIST
(
  ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
  ID_OWNER INTEGER,
  DURATION INTEGER
);

CREATE TABLE STYLE
(
  ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
  NAME VARCHAR(255)
);

CREATE TABLE TRACK
(
  ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
  NAME VARCHAR(255),
  DURATION INTEGER,
  ID_STYLE INTEGER,
  CONSTRAINT TRACK_STYLE_ID_FK FOREIGN KEY (ID_STYLE) REFERENCES STYLE (ID)
);
CREATE INDEX TRACK_STYLE_ID_FK_INDEX_4 ON TRACK (ID_STYLE);

CREATE TABLE USER
(
  ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
  NAME VARCHAR(255),
  ID_ACCOUNT INTEGER,
  CONSTRAINT USER_ACCOUNT_ID_FK FOREIGN KEY (ID_ACCOUNT) REFERENCES ACCOUNT (ID)
);
CREATE INDEX USER_ACCOUNT_ID_FK_INDEX_2 ON USER (ID_ACCOUNT);