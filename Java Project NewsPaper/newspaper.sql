/*
Navicat MySQL Data Transfer

Source Server         : BCE
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : newspaper

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-07-15 13:47:12
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `areas`
-- ----------------------------
DROP TABLE IF EXISTS `areas`;
CREATE TABLE `areas` (
  `Area` varchar(100) NOT NULL,
  PRIMARY KEY (`Area`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of areas
-- ----------------------------
INSERT INTO `areas` VALUES ('Ajit Road');
INSERT INTO `areas` VALUES ('Bharat Nagar');
INSERT INTO `areas` VALUES ('Bibi Wala');
INSERT INTO `areas` VALUES ('Chandni Chowk');
INSERT INTO `areas` VALUES ('Delhi');
INSERT INTO `areas` VALUES ('Ganesha Basti');
INSERT INTO `areas` VALUES ('Ganpati Enclave');
INSERT INTO `areas` VALUES ('Govind Colony');
INSERT INTO `areas` VALUES ('Green Avenue');
INSERT INTO `areas` VALUES ('Guru Gobind Singh Nagar');
INSERT INTO `areas` VALUES ('Jhujhar Singh Nagar');
INSERT INTO `areas` VALUES ('Kamla Nehru Colony');
INSERT INTO `areas` VALUES ('Model Town Phase I');
INSERT INTO `areas` VALUES ('Model Town Phase II');
INSERT INTO `areas` VALUES ('Model Town Phase III');
INSERT INTO `areas` VALUES ('Patel Nagar');
INSERT INTO `areas` VALUES ('Pratap Nagar');
INSERT INTO `areas` VALUES ('Singham Colony');
INSERT INTO `areas` VALUES ('Urban Estate');

-- ----------------------------
-- Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `Cid` varchar(100) NOT NULL DEFAULT '',
  `Bill` double(100,0) DEFAULT NULL,
  `Status` int(100) NOT NULL DEFAULT '0',
  `Month` int(100) NOT NULL DEFAULT '0',
  `Year` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`Cid`,`Status`,`Month`,`Year`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('27', '527', '0', '1', '2012');
INSERT INTO `bill` VALUES ('27', '527', '0', '3', '2014');
INSERT INTO `bill` VALUES ('27', '527', '0', '3', '2017');
INSERT INTO `bill` VALUES ('27', '510', '0', '6', '2014');
INSERT INTO `bill` VALUES ('27', '527', '0', '7', '2017');
INSERT INTO `bill` VALUES ('27', '336', '1', '3', '2017');
INSERT INTO `bill` VALUES ('28', '279', '0', '1', '2012');
INSERT INTO `bill` VALUES ('28', '279', '0', '3', '2014');
INSERT INTO `bill` VALUES ('28', '270', '0', '6', '2014');
INSERT INTO `bill` VALUES ('28', '279', '0', '7', '2017');
INSERT INTO `bill` VALUES ('28', '279', '1', '3', '2017');
INSERT INTO `bill` VALUES ('29', '434', '0', '1', '2012');
INSERT INTO `bill` VALUES ('29', '434', '0', '3', '2014');
INSERT INTO `bill` VALUES ('29', '434', '0', '3', '2017');
INSERT INTO `bill` VALUES ('29', '420', '0', '6', '2014');
INSERT INTO `bill` VALUES ('29', '434', '0', '7', '2017');
INSERT INTO `bill` VALUES ('30', '651', '0', '1', '2012');
INSERT INTO `bill` VALUES ('30', '651', '0', '3', '2014');
INSERT INTO `bill` VALUES ('30', '630', '0', '6', '2014');
INSERT INTO `bill` VALUES ('30', '651', '0', '7', '2017');
INSERT INTO `bill` VALUES ('30', '651', '1', '3', '2017');
INSERT INTO `bill` VALUES ('31', '589', '0', '1', '2012');
INSERT INTO `bill` VALUES ('31', '589', '0', '3', '2014');
INSERT INTO `bill` VALUES ('31', '589', '0', '3', '2017');
INSERT INTO `bill` VALUES ('31', '570', '0', '6', '2014');
INSERT INTO `bill` VALUES ('31', '589', '0', '7', '2017');
INSERT INTO `bill` VALUES ('32', '217', '0', '1', '2012');
INSERT INTO `bill` VALUES ('32', '217', '0', '3', '2014');
INSERT INTO `bill` VALUES ('32', '210', '0', '6', '2014');
INSERT INTO `bill` VALUES ('32', '217', '0', '7', '2017');
INSERT INTO `bill` VALUES ('32', '217', '1', '3', '2017');
INSERT INTO `bill` VALUES ('33', '217', '0', '1', '2012');
INSERT INTO `bill` VALUES ('33', '217', '0', '3', '2014');
INSERT INTO `bill` VALUES ('33', '217', '0', '3', '2017');
INSERT INTO `bill` VALUES ('33', '210', '0', '6', '2014');
INSERT INTO `bill` VALUES ('33', '217', '0', '7', '2017');
INSERT INTO `bill` VALUES ('34', '0', '0', '1', '2012');
INSERT INTO `bill` VALUES ('34', '0', '0', '3', '2014');
INSERT INTO `bill` VALUES ('34', '0', '0', '6', '2014');
INSERT INTO `bill` VALUES ('34', '0', '0', '7', '2017');
INSERT INTO `bill` VALUES ('34', '0', '1', '3', '2017');
INSERT INTO `bill` VALUES ('35', '0', '0', '1', '2012');
INSERT INTO `bill` VALUES ('35', '0', '0', '3', '2014');
INSERT INTO `bill` VALUES ('35', '0', '0', '3', '2017');
INSERT INTO `bill` VALUES ('35', '0', '0', '6', '2014');
INSERT INTO `bill` VALUES ('35', '0', '0', '7', '2017');
INSERT INTO `bill` VALUES ('36', '0', '0', '1', '2012');
INSERT INTO `bill` VALUES ('36', '0', '0', '3', '2014');
INSERT INTO `bill` VALUES ('36', '0', '0', '6', '2014');
INSERT INTO `bill` VALUES ('36', '0', '0', '7', '2017');
INSERT INTO `bill` VALUES ('36', '0', '1', '3', '2017');
INSERT INTO `bill` VALUES ('37', '0', '0', '1', '2012');
INSERT INTO `bill` VALUES ('37', '0', '0', '3', '2014');
INSERT INTO `bill` VALUES ('37', '0', '0', '3', '2017');
INSERT INTO `bill` VALUES ('37', '0', '0', '6', '2014');
INSERT INTO `bill` VALUES ('37', '0', '0', '7', '2017');
INSERT INTO `bill` VALUES ('38', '0', '0', '1', '2012');
INSERT INTO `bill` VALUES ('38', '0', '0', '3', '2014');
INSERT INTO `bill` VALUES ('38', '0', '0', '3', '2017');
INSERT INTO `bill` VALUES ('38', '0', '0', '6', '2014');
INSERT INTO `bill` VALUES ('38', '0', '0', '7', '2017');
INSERT INTO `bill` VALUES ('39', '0', '0', '1', '2012');
INSERT INTO `bill` VALUES ('39', '0', '0', '3', '2014');
INSERT INTO `bill` VALUES ('39', '0', '0', '3', '2017');
INSERT INTO `bill` VALUES ('39', '0', '0', '6', '2014');
INSERT INTO `bill` VALUES ('39', '0', '0', '7', '2017');
INSERT INTO `bill` VALUES ('40', '0', '0', '1', '2012');
INSERT INTO `bill` VALUES ('40', '0', '0', '3', '2014');
INSERT INTO `bill` VALUES ('40', '0', '0', '3', '2017');
INSERT INTO `bill` VALUES ('40', '0', '0', '6', '2014');
INSERT INTO `bill` VALUES ('40', '0', '0', '7', '2017');

-- ----------------------------
-- Table structure for `hawkerregistration`
-- ----------------------------
DROP TABLE IF EXISTS `hawkerregistration`;
CREATE TABLE `hawkerregistration` (
  `Hname` varchar(30) NOT NULL,
  `Mobile` varchar(13) DEFAULT NULL,
  `Area` varchar(300) DEFAULT NULL,
  `Adress` varchar(300) DEFAULT NULL,
  `IdProof` varchar(300) DEFAULT NULL,
  `Doj` date DEFAULT NULL,
  PRIMARY KEY (`Hname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hawkerregistration
-- ----------------------------
INSERT INTO `hawkerregistration` VALUES ('Abc', '989898', 'Govind Colony,Pratap Nagar,Urban Estate,', 'pqr', 'file:/C:/Users/Gaurav%20Kumar/Desktop/Pics/animated2.gif', '2017-07-09');
INSERT INTO `hawkerregistration` VALUES ('agagagaga', 'yuguiuigui', 'Ajit Road,Bharat Nagar,Bibi Wala,', 'bilbilbilbjk', 'file:/C:/Users/Gaurav%20Kumar/Desktop/Pics/logo6.gif', '2017-07-13');
INSERT INTO `hawkerregistration` VALUES ('Def', '', 'Govind Colony,Green Avenue,', 'jhggggg', 'file:/C:/Users/Gaurav%20Kumar/Desktop/Pics/cancel.png', '2017-07-09');
INSERT INTO `hawkerregistration` VALUES ('Gaurav', '8906214155', 'Ajit Road,Bharat Nagar,Model Town Phase III,Patel Nagar,Pratap Nagar,', 'Patel Nagar ', 'file:/C:/Users/Gaurav%20Kumar/Desktop/Pics/add.png', '2017-07-09');
INSERT INTO `hawkerregistration` VALUES ('papapapapapapap', '', '', '', '', '2017-07-13');
INSERT INTO `hawkerregistration` VALUES ('Saurav', '1211222', 'Bharat Nagar,Ganesha Basti,Singham Colony,', 'ABCDREF', 'file:/C:/Users/Gaurav%20Kumar/Desktop/Pics/addd.png', '2017-07-09');

-- ----------------------------
-- Table structure for `logusers`
-- ----------------------------
DROP TABLE IF EXISTS `logusers`;
CREATE TABLE `logusers` (
  `Uid` varchar(100) NOT NULL DEFAULT '',
  `Password` varchar(100) DEFAULT NULL,
  `Mobile` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`Uid`,`Mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of logusers
-- ----------------------------
INSERT INTO `logusers` VALUES ('123', '123', '9465394551');

-- ----------------------------
-- Table structure for `newspapers`
-- ----------------------------
DROP TABLE IF EXISTS `newspapers`;
CREATE TABLE `newspapers` (
  `NewPaperName` varchar(30) NOT NULL DEFAULT '',
  `Price` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`NewPaperName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of newspapers
-- ----------------------------
INSERT INTO `newspapers` VALUES ('Deccan', '6');
INSERT INTO `newspapers` VALUES ('Deccan Chronicle', '1.00');
INSERT INTO `newspapers` VALUES ('Hindustan Times', '8.00');
INSERT INTO `newspapers` VALUES ('National Herald', '15.00');
INSERT INTO `newspapers` VALUES ('Punjab Kesri', '1.50');
INSERT INTO `newspapers` VALUES ('Sikkim Express', '8');
INSERT INTO `newspapers` VALUES ('The Hindu', '4.00');
INSERT INTO `newspapers` VALUES ('The New Indian Express', '5.00');
INSERT INTO `newspapers` VALUES ('Times Of India', '5.00');
INSERT INTO `newspapers` VALUES ('Tribune', '3.50');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `Name` varchar(30) DEFAULT NULL,
  `Adress` varchar(100) DEFAULT NULL,
  `Area` varchar(100) DEFAULT NULL,
  `Hawkers` varchar(100) DEFAULT NULL,
  `Mobile` varchar(13) DEFAULT '',
  `NewsPapers` varchar(100) DEFAULT NULL,
  `Rates` varchar(100) DEFAULT NULL,
  `bill` double(100,0) DEFAULT NULL,
  `Id` int(100) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('Gaurav', 'ABCDEF', 'Ajit Road', 'Gaurav', '8906214155', 'Dainik Bhaskar,Deccan Chronicle,National Herald,', '1.00/1.00/15.00/', '17', '27');
INSERT INTO `users` VALUES ('Patel', 'uioguiogiog', 'Bharat Nagar', 'Saurav', '999999999', 'Deccan Chronicle,Hindustan Times,', '1.00/8.00/', '9', '28');
INSERT INTO `users` VALUES ('raka', 'uioguiogiobgio', 'Govind Colony', 'Abc', '12344566666', 'Hindustan Times,Punjab Kesri,Sikkim Express,', '8.00/1.50/5.00/', '14', '29');
INSERT INTO `users` VALUES ('Shaka', 'uifiuvuogbuoi', 'Govind Colony', 'Abc', '98777777777', 'Punjab Kesri,National Herald,Sikkim Express,', '1.50/15.00/5.00/', '21', '30');
INSERT INTO `users` VALUES ('Dhaka', 'jhvujv jvh', null, null, '15123', 'Deccan,', '6,', '19', '31');
INSERT INTO `users` VALUES ('Gaurav', 'Gaurav', 'Bharat Nagar', 'Gaurav', '8906214155', 'Dainik Bhaskar,Deccan,', '1.00/6/', '7', '32');
INSERT INTO `users` VALUES ('Saurab', 'ababababababababababa', 'Bharat Nagar', 'Gaurav', '9999999', 'Deccan,Deccan Chronicle,', '6/1.00/', '7', '33');
INSERT INTO `users` VALUES ('bukbkbkuj', '', null, null, '', '', '', '0', '34');
INSERT INTO `users` VALUES ('apapapapapapap', '', null, null, '', '', '', '0', '35');
INSERT INTO `users` VALUES ('llllllllllllll', '', null, null, '', '', '', '0', '36');
INSERT INTO `users` VALUES ('ugiuiojk', '', null, null, '', '', '', '0', '37');
INSERT INTO `users` VALUES ('jbubkj', '', null, null, '', '', '', '0', '38');
INSERT INTO `users` VALUES ('mmmmmmmmm', '', null, null, '', '', '', '0', '39');
INSERT INTO `users` VALUES ('yyyyyyyyyyyy', '', null, null, '', '', '', '0', '40');
INSERT INTO `users` VALUES ('ogiogoigoih', 'iogbiogiobg', 'Bharat Nagar', 'Gaurav', 'jkbilbkl', 'Deccan,Deccan Chronicle,', '6/1.00/', '7', '41');
