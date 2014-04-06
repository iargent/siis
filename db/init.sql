SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE DATABASE siis;

-- -----------------------------------------------------
-- Table `siis`.`BaseSchool`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `siis`.`BaseSchool` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siis`.`Fact`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `siis`.`Fact` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `when` DATETIME NULL ,
  `targetType` ENUM('school', 'person','authority') NOT NULL ,
  `targetId` INT UNSIGNED NULL ,
  `sourceId` INT UNSIGNED NULL ,
  `key` VARCHAR(45) NULL ,
  `value` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `siis`.`School`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `siis`.`School` (
  `baseSchoolId` INT NOT NULL ,
  `name` VARCHAR(45) NULL ,
  PRIMARY KEY (`baseSchoolId`) )
ENGINE = MyISAM;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
