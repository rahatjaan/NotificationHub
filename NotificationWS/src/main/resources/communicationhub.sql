CREATE SCHEMA `communication_hub` ;

CREATE  TABLE `communication_hub`.`notifications` (

  `id` INT NOT NULL AUTO_INCREMENT ,

  `subject` VARCHAR(100) NULL ,

  `to` VARCHAR(200) NULL ,

  `from` VARCHAR(200) NULL ,

  `messageBody` TEXT NULL ,

  `recipient_guid` VARCHAR(45) NULL ,

  PRIMARY KEY (`id`) );

