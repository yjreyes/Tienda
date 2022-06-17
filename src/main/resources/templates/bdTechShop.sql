/*Las líneas 2 y 3 están en comentarios, para usarse así la primera vez... luego de eso se quitan los comentarios para que todo funcione bien, en las siguientes ejecuciones */
/*
*/
-- drop user usuario_prueba;
-- drop schema techshop ;
-- drop table techshop;
/*Se crea la base de datos */
CREATE SCHEMA `techshop` ;
use techshop;
/*Se crea la tabla de clientes llamada cliente... igual que la clase Cliente */
CREATE TABLE `techshop`.`cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  `apellidos` VARCHAR(30) NOT NULL,
  `correo` VARCHAR(25) NULL,
  `telefono` VARCHAR(15) NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

/*Se insertan 3 registros en la tabla cliente como ejemplo */
INSERT INTO `techshop`.`cliente` (`id_cliente`, `nombre`, `apellidos`, `correo`, `telefono`) VALUES ('1', 'Juan', 'Castro Mora', 'jcastro@gmail.com', '4556-8978');
INSERT INTO `techshop`.`cliente` (`id_cliente`, `nombre`, `apellidos`, `correo`, `telefono`) VALUES ('2', 'Ana', 'Contreras Mora', 'acontreras@gmail.com', '5456-8789');
INSERT INTO `techshop`.`cliente` (`id_cliente`, `nombre`, `apellidos`, `correo`, `telefono`) VALUES ('3', 'Luis', 'Mena Loria', 'lmena@gmail.com', '7898-8936');

/*Se crea un usuario para la base de datos llamado "usuario_prueba" y tiene la contraseña "Usuario_Clave."*/
create user 'usuario_prueba'@'%' identified by 'Usuar1o_Clave.';
/*Se asignan los prvilegios sobr ela base de datos TechShop al usuario creado */
grant all privileges on techshop.* to 'usuario_prueba'@'%';
flush privileges;
