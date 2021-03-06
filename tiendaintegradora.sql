-- MySQL Script generated by MySQL Workbench
-- Fri Nov 27 21:52:19 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tiendaintegradora
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tiendaintegradora
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tiendaintegradora` DEFAULT CHARACTER SET utf8 ;
USE `tiendaintegradora` ;

-- -----------------------------------------------------
-- Table `tiendaintegradora`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendaintegradora`.`categoria` (
  `idCategoria` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tiendaintegradora`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendaintegradora`.`marca` (
  `idMarca` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`idMarca`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tiendaintegradora`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendaintegradora`.`producto` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  `idMarca` INT(11) NOT NULL,
  `existencia` INT(11) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  `codigoBarra` VARCHAR(20) NOT NULL COMMENT 'dame 2m',
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC),
  INDEX `FKIDMARCA_idx` (`idMarca` ASC) VISIBLE,
  INDEX `FKIDCATEGORIA_idx` (`idCategoria` ASC),
  CONSTRAINT `FKIDCATEGORIA`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `tiendaintegradora`.`categoria` (`idCategoria`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FKIDMARCA`
    FOREIGN KEY (`idMarca`)
    REFERENCES `tiendaintegradora`.`marca` (`idMarca`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tiendaintegradora`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendaintegradora`.`usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nick` VARCHAR(15) NOT NULL,
  `contrasenia` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
