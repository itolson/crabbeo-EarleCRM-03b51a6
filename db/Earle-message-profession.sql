insert into messages
VALUES (1,'itolson','jbloggs','01/01/12','01/01/13','this is a test message');
use earle;

commit;

insert into USERDETAILS 
VALUES (2,0,'10/09/12','welcome1','itolson');

insert into profession 
VALUES ('AA2','Architects Engineers');

delete from userdetails where ID='2';

select * from UserDetails;

DROP TABLE IF EXISTS `USERDETAILS`;
/*!40101 SET @saved_cs_client     = @@character_set_userdetailsclient */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERDETAILS` (
  `ID` bigint(20) NOT NULL,
  `failedAttempts` int(11) DEFAULT NULL,
  `lastSuccessfulLogin` date DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `userId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `PROFESSION`;
CREATE TABLE `PROFESSION` (
  `ID` varchar(5) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `MESSAGES`;
CREATE TABLE `MESSAGES` (
  `ID` bigint(20) NOT NULL,
  `idFrom` varchar(32) DEFAULT NULL,
  `idTo` varchar(32) DEFAULT NULL,
  `dateSent` date DEFAULT NULL,
  `dateRead` date DEFAULT NULL,
  `message` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


select * from profession;
