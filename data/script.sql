-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema empleadosbd
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `empleadosbd` ;

-- -----------------------------------------------------
-- Schema empleadosbd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empleadosbd` DEFAULT CHARACTER SET utf8 ;
USE `empleadosbd` ;

-- -----------------------------------------------------
-- Table `empleadosbd`.`empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empleadosbd`.`empleado` ;

CREATE TABLE IF NOT EXISTS `empleadosbd`.`empleado` (
  `documento` VARCHAR(12) NOT NULL,
  `tipo_documento` VARCHAR(24) NOT NULL,
  `nombres` VARCHAR(32) NOT NULL,
  `apellidos` VARCHAR(32) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `fecha_vinculacion` DATE NOT NULL,
  `cargo` VARCHAR(32) NOT NULL,
  `salario` DOUBLE(8,2) NOT NULL,
  PRIMARY KEY (`documento`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `empleadosbd`.`empleado`
-- -----------------------------------------------------
START TRANSACTION;
USE `empleadosbd`;
INSERT INTO `empleadosbd`.`empleado` (`documento`, `tipo_documento`, `nombres`, `apellidos`, `fecha_nacimiento`, `fecha_vinculacion`, `cargo`, `salario`) VALUES ('1001', 'C.C.', 'Jimena', 'Jímenez', '2000-12-19', '2019-01-01', 'Programador', 1000);
INSERT INTO `empleadosbd`.`empleado` (`documento`, `tipo_documento`, `nombres`, `apellidos`, `fecha_nacimiento`, `fecha_vinculacion`, `cargo`, `salario`) VALUES ('1002', 'C.C.', 'Felipe', 'Gónzalez', '1999-10-20', '2018-06-01', 'Programador', 1200);

COMMIT;

