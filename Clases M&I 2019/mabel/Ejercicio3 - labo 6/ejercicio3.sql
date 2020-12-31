/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : ejercicio3

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2019-12-06 10:54:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clientes
-- ----------------------------
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `nro_cuenta` int(10) DEFAULT NULL,
  `nro_ci` int(10) DEFAULT NULL,
  `nombre_completo` varchar(50) DEFAULT NULL,
  `fecha_apertura_cuenta` varchar(255) DEFAULT NULL,
  `saldo_actual` double(11,2) DEFAULT NULL,
  `pin` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clientes
-- ----------------------------
INSERT INTO `clientes` VALUES ('1', '2525650', 'Juan Perez Torrez', '24/01/2018', '1478.50', '1111');
INSERT INTO `clientes` VALUES ('2', '4545650', 'Maria Quispe Toledo', '07/09/2019', '1350.70', '2222');
INSERT INTO `clientes` VALUES ('3', '6060889', 'Carlos Quinteros Sanchez', '28/02/2018', '2060.00', '3333');
INSERT INTO `clientes` VALUES ('4', '8896542', 'Santos Quispe Poma', '08/08/2010', '58545.00', '4444');

-- ----------------------------
-- Table structure for transacciones
-- ----------------------------
DROP TABLE IF EXISTS `transacciones`;
CREATE TABLE `transacciones` (
  `nro_cuenta` int(11) DEFAULT NULL,
  `fecha_transaccion` varchar(50) DEFAULT NULL,
  `tipo_transaccion` varchar(20) DEFAULT NULL,
  `monto_transaccion` double(11,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transacciones
-- ----------------------------
INSERT INTO `transacciones` VALUES ('2', '06/12/2019 10:26:55', 'RETIRO', '500.00');
INSERT INTO `transacciones` VALUES ('1', '06/12/2019 10:37:40', 'RETIRO', '20.00');
INSERT INTO `transacciones` VALUES ('1', '06/12/2019 10:37:47', 'RETIRO', '25.00');
INSERT INTO `transacciones` VALUES ('1', '06/12/2019 10:37:54', 'RETIRO', '150.00');
INSERT INTO `transacciones` VALUES ('4', '06/12/2019 10:41:26', ' RETIRO ', '150.00');
INSERT INTO `transacciones` VALUES ('4', '06/12/2019 10:41:35', 'DEPOSITO', '12000.00');
INSERT INTO `transacciones` VALUES ('4', '06/12/2019 10:41:55', ' RETIRO ', '1500.00');
INSERT INTO `transacciones` VALUES ('3', '06/12/2019 10:43:47', ' RETIRO ', '320.00');
INSERT INTO `transacciones` VALUES ('1', '06/12/2019 10:44:03', 'DEPOSITO', '550.00');
INSERT INTO `transacciones` VALUES ('1', '06/12/2019 10:44:10', 'DEPOSITO', '1500.00');
INSERT INTO `transacciones` VALUES ('1', '06/12/2019 10:44:17', ' RETIRO ', '220.00');
INSERT INTO `transacciones` VALUES ('3', '06/12/2019 10:44:40', 'DEPOSITO', '800.00');
INSERT INTO `transacciones` VALUES ('1', '06/12/2019 10:53:03', ' RETIRO ', '550.00');
INSERT INTO `transacciones` VALUES ('3', '06/12/2019 10:53:18', 'DEPOSITO', '480.00');
INSERT INTO `transacciones` VALUES ('3', '06/12/2019 10:53:28', 'DEPOSITO', '600.00');
