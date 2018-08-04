DROP DATABASE IF EXISTS `ex`;
CREATE DATABASE IF NOT EXISTS `ex`;
USE `ex`;

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(30) NOT NULL,
  `regdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

DELETE FROM `users`;
INSERT INTO `users` (`id`, `email`, `password`, `name`, `regdate`, `updatedate`) VALUES
	(1, 'seongbin@gmail.com', '1234', 'Seongbin Kim', '2018-08-04 13:16:04', '2018-08-04 13:16:05'),
	(2, 'seEun@gmail.com', 'seEunPassword', '심세은', '2018-08-04 13:31:26', '2018-08-04 13:31:26');
