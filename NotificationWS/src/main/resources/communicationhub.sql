CREATE SCHEMA `communication_hub` ;

CREATE  TABLE `communication_hub`.`notifications` (

  `id` INT NOT NULL AUTO_INCREMENT ,

  `subject` VARCHAR(100) NULL ,

  `to` VARCHAR(200) NULL ,

  `from` VARCHAR(200) NULL ,

  `messageBody` TEXT NULL ,

  `recipient_guid` VARCHAR(45) NULL ,

  PRIMARY KEY (`id`) );


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

