CREATE TABLE `TB_BOOK` (
  `BOO_ID` INT(10) AUTO_INCREMENT PRIMARY KEY,
  `BOO_AUTHOR` longtext,
  `BOO_LAUNCHDATE` datetime(6) NOT NULL,
  `BOO_PRICE` decimal(65,2) NOT NULL,
  `BOO_TITLE` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
