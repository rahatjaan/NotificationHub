CREATE SCHEMA `communication_hub` ;
use `communication_hub`;

CREATE TABLE `notifications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notification_subject` varchar(100) DEFAULT NULL,
  `notification_to` varchar(200) DEFAULT NULL,
  `notification_from` varchar(200) DEFAULT NULL,
  `messageBody` text,
  `sender_guid` varchar(45) DEFAULT NULL,
  `receiver_guid` varchar(45) DEFAULT NULL,
  `sender_tenant_guid` varchar(45) DEFAULT NULL,
  `receiver_tenant_guid` varchar(45) DEFAULT NULL,
  `received_date` datetime DEFAULT NULL,
  `forward` int(11) DEFAULT NULL,
  `forwardDate` datetime DEFAULT NULL,
  `forwardEmail` varchar(45) DEFAULT NULL,
  `messagetype` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)


  CREATE TABLE `attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notification_id` int(11) NOT NULL,
  `content_type` VARCHAR(45) NULL ,
  `attachement` blob,
  PRIMARY KEY (`id`)
) ;


CREATE  TABLE `communication_hub`.`user` (

  `id` INT NOT NULL AUTO_INCREMENT ,

  `userGuid` VARCHAR(45) NULL ,

  `username` VARCHAR(45) NULL ,

  `password` VARCHAR(45) NULL ,

  `active` INT NULL DEFAULT 1 ,

  PRIMARY KEY (`id`) );

