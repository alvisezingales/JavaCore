-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema restaurantgruppo4
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema restaurantgruppo4
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `restaurantgruppo4` DEFAULT CHARACTER SET utf8 ;
USE `restaurantgruppo4` ;

-- -----------------------------------------------------
-- Table `restaurantgruppo4`.`restaurant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantgruppo4`.`restaurant` (
  `id_restaurant` INT NOT NULL AUTO_INCREMENT,
  `restaurant_name` VARCHAR(64) NOT NULL,
  `restaurant_address` VARCHAR(64) NOT NULL,
  `seating_capacity` INT NOT NULL,
  `restaurant_avg_price` DECIMAL NOT NULL,
  `restaurant_recomm_dish` VARCHAR(64) NOT NULL,
  `restaurant_services` VARCHAR(64) NOT NULL,
  `has_home_delivery` TINYINT NOT NULL,
  `has_all_you_can_eat` TINYINT NOT NULL,
  `is_open` TINYINT NOT NULL,
  `tableservice` ENUM('buffet', 'a_la_carte') NOT NULL,
  PRIMARY KEY (`id_restaurant`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurantgruppo4`.`menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantgruppo4`.`menu` (
  `id_menu` INT NOT NULL AUTO_INCREMENT,
  `menu_preferences` ENUM('carnivorous', 'vegetarian', 'vegan', 'mixed') NOT NULL,
  `menu_based_on` ENUM('fish', 'meat', 'vegetable') NOT NULL,
  `menu_type_of_menu` ENUM('special', 'children', 'tasting', 'daily') NOT NULL,
  `restaurant_id_restaurant` INT NOT NULL,
  PRIMARY KEY (`id_menu`),
  INDEX `fk_menu_restaurant_idx` (`restaurant_id_restaurant` ASC) VISIBLE,
  CONSTRAINT `fk_menu_restaurant`
    FOREIGN KEY (`restaurant_id_restaurant`)
    REFERENCES `restaurantgruppo4`.`restaurant` (`id_restaurant`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurantgruppo4`.`first_course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantgruppo4`.`first_course` (
  `id_dish` INT NOT NULL AUTO_INCREMENT,
  `dish_name` VARCHAR(64) NOT NULL,
  `dish_course` VARCHAR(32) NOT NULL,
  `dish_ingredients` VARCHAR(255) NOT NULL,
  `dish_price` DECIMAL NOT NULL,
  `dish_preferences` ENUM('carnivorous', 'vegetarian', 'vegan', 'mixed') NOT NULL,
  `dish_dietary_options` ENUM('lactose_free', 'gluten_free', 'peanut_free', 'locally_produced') NOT NULL,
  `dish_type` ENUM('drink', 'first_course', 'second_course', 'dessert') NOT NULL,
  `first_course_is_pasta_fresca` TINYINT NOT NULL,
  `menu_id_menu` INT NOT NULL,
  PRIMARY KEY (`id_dish`),
  INDEX `fk_first_course_menu1_idx` (`menu_id_menu` ASC) VISIBLE,
  CONSTRAINT `fk_first_course_menu1`
    FOREIGN KEY (`menu_id_menu`)
    REFERENCES `restaurantgruppo4`.`menu` (`id_menu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurantgruppo4`.`table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantgruppo4`.`table` (
  `id_table` INT NOT NULL AUTO_INCREMENT,
  `table_seats_number` INT NOT NULL,
  `table_position` ENUM('indoor', 'outdoor') NOT NULL,
  `table_is_available` TINYINT NOT NULL,
  `restaurant_id_restaurant` INT NOT NULL,
  PRIMARY KEY (`id_table`),
  INDEX `fk_table_restaurant1_idx` (`restaurant_id_restaurant` ASC) VISIBLE,
  CONSTRAINT `fk_table_restaurant1`
    FOREIGN KEY (`restaurant_id_restaurant`)
    REFERENCES `restaurantgruppo4`.`restaurant` (`id_restaurant`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurantgruppo4`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantgruppo4`.`customer` (
  `id_customer_table` INT NOT NULL AUTO_INCREMENT,
  `id_customer_generated` INT NOT NULL,
  `customer_name` VARCHAR(64) NOT NULL,
  `customer_surname` VARCHAR(64) NOT NULL,
  `customer_telephone` VARCHAR(32) NOT NULL,
  `customer_email` VARCHAR(64) NOT NULL,
  `customer_group_size` INT NOT NULL,
  `customer_preferences` ENUM('carnivorous', 'vegetarian', 'vegan', 'mixed') NOT NULL,
  PRIMARY KEY (`id_customer_table`),
  UNIQUE INDEX `id_customer_generated_UNIQUE` (`id_customer_generated` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurantgruppo4`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantgruppo4`.`booking` (
  `id_booking_table` INT NOT NULL AUTO_INCREMENT,
  `id_booking_generated` INT NOT NULL,
  `booking_date_time` DATETIME NOT NULL,
  `booking_group_size` INT NOT NULL,
  `customer_id_customer_table` INT NOT NULL,
  PRIMARY KEY (`id_booking_table`),
  INDEX `fk_booking_customer1_idx` (`customer_id_customer_table` ASC) VISIBLE,
  CONSTRAINT `fk_booking_customer1`
    FOREIGN KEY (`customer_id_customer_table`)
    REFERENCES `restaurantgruppo4`.`customer` (`id_customer_table`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `restaurantgruppo4`.`table_has_booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantgruppo4`.`table_has_booking` (
  `table_id_table` INT NOT NULL,
  `booking_id_booking_table` INT NOT NULL,
  `table_has_booking_date_time` DATETIME NOT NULL,
  PRIMARY KEY (`table_id_table`, `booking_id_booking_table`),
  INDEX `fk_table_has_booking_booking1_idx` (`booking_id_booking_table` ASC) VISIBLE,
  INDEX `fk_table_has_booking_table1_idx` (`table_id_table` ASC) VISIBLE,
  CONSTRAINT `fk_table_has_booking_table1`
    FOREIGN KEY (`table_id_table`)
    REFERENCES `restaurantgruppo4`.`table` (`id_table`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table_has_booking_booking1`
    FOREIGN KEY (`booking_id_booking_table`)
    REFERENCES `restaurantgruppo4`.`booking` (`id_booking_table`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurantgruppo4`.`second_course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantgruppo4`.`second_course` (
  `id_dish` INT NOT NULL AUTO_INCREMENT,
  `dish_name` VARCHAR(64) NOT NULL,
  `dish_course` VARCHAR(32) NOT NULL,
  `dish_ingredients` VARCHAR(255) NOT NULL,
  `dish_price` DECIMAL NOT NULL,
  `dish_preferences` ENUM('carnivorous', 'vegetarian', 'vegan', 'mixed') NOT NULL,
  `dish_dietary_options` ENUM('lactose_free', 'gluten_free', 'peanut_free', 'locally_produced') NOT NULL,
  `dish_type` ENUM('drink', 'first_course', 'second_course', 'dessert') NOT NULL,
  `second_course_side_dish` VARCHAR(64) NOT NULL,
  `menu_id_menu` INT NOT NULL,
  PRIMARY KEY (`id_dish`),
  INDEX `fk_second_course_menu1_idx` (`menu_id_menu` ASC) VISIBLE,
  CONSTRAINT `fk_second_course_menu1`
    FOREIGN KEY (`menu_id_menu`)
    REFERENCES `restaurantgruppo4`.`menu` (`id_menu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurantgruppo4`.`dessert`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantgruppo4`.`dessert` (
  `id_dish` INT NOT NULL AUTO_INCREMENT,
  `dish_name` VARCHAR(64) NOT NULL,
  `dish_course` VARCHAR(32) NOT NULL,
  `dish_ingredients` VARCHAR(255) NOT NULL,
  `dish_price` DECIMAL NOT NULL,
  `dish_preferences` ENUM('carnivorous', 'vegetarian', 'vegan', 'mixed') NOT NULL,
  `dish_dietary_options` ENUM('lactose_free', 'gluten_free', 'peanut_free', 'locally_produced') NOT NULL,
  `dish_type` ENUM('drink', 'first_course', 'second_course', 'dessert') NOT NULL,
  `dessert_is_home_made` TINYINT NOT NULL,
  `menu_id_menu` INT NOT NULL,
  PRIMARY KEY (`id_dish`),
  INDEX `fk_dessert_menu1_idx` (`menu_id_menu` ASC) VISIBLE,
  CONSTRAINT `fk_dessert_menu1`
    FOREIGN KEY (`menu_id_menu`)
    REFERENCES `restaurantgruppo4`.`menu` (`id_menu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `restaurantgruppo4`.`drink`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantgruppo4`.`drink` (
  `id_dish` INT NOT NULL AUTO_INCREMENT,
  `dish_name` VARCHAR(64) NOT NULL,
  `dish_course` VARCHAR(32) NOT NULL,
  `dish_ingredients` VARCHAR(255) NOT NULL,
  `dish_price` DECIMAL NOT NULL,
  `dish_preferences` ENUM('carnivorous', 'vegetarian', 'vegan', 'mixed') NOT NULL,
  `dish_dietary_options` ENUM('lactose_free', 'gluten_free', 'peanut_free', 'locally_produced') NOT NULL,
  `dish_type` ENUM('drink', 'first_course', 'second_course', 'dessert') NOT NULL,
  `drink_alcoholic_volume` DECIMAL NOT NULL,
  `drink_is_alcoholic` TINYINT NOT NULL,
  `menu_id_menu` INT NOT NULL,
  PRIMARY KEY (`id_dish`),
  INDEX `fk_drink_menu1_idx` (`menu_id_menu` ASC) VISIBLE,
  CONSTRAINT `fk_drink_menu1`
    FOREIGN KEY (`menu_id_menu`)
    REFERENCES `restaurantgruppo4`.`menu` (`id_menu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


