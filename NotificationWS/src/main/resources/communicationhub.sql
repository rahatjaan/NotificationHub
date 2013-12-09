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
  `attachement` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

