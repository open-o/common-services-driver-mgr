CREATE DATABASE driverMgrDB;
CREATE TABLE IF NOT EXISTS driverMgrDB.TBL_INSTANCE(INSTANCEID VARCHAR(255) NOT NULL,DRIVERNAME VARCHAR(255) NOT NULL,MODEL TEXT NOT NULL,EXTENDINFO TEXT,PRIMARY KEY (INSTANCEID));
CREATE TABLE IF NOT EXISTS driverMgrDB.TBL_SERVICE(SERVICEURL VARCHAR(255) NOT NULL,INSTANCEID VARCHAR(255) NOT NULL,EXTENDINFO TEXT);