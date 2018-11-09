/*
 Navicat Premium Data Transfer

 Source Server         : LapScotia
 Source Server Type    : PostgreSQL
 Source Server Version : 90325
 Source Host           : localhost:5432
 Source Catalog        : abanking_error_matrix
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90325
 File Encoding         : 65001

 Date: 09/11/2018 11:36:21
*/


-- ----------------------------
-- Table structure for error_matrix
-- ----------------------------
DROP TABLE IF EXISTS error_matrix;
CREATE TABLE error_matrix (
  error_code varchar(20) COLLATE pg_catalog.default NOT NULL,
  status varchar(50) COLLATE pg_catalog.default NOT NULL,
  message varchar(250) COLLATE pg_catalog.default NOT NULL
)
;

-- ----------------------------
-- Records of error_matrix
-- ----------------------------
INSERT INTO error_matrix VALUES ('BC-CA-100', '1', '¡Lo sentimos! Hay un problema de conexión para completar tu solicitud.');
INSERT INTO error_matrix VALUES ('BC-CA-101', '1', '¡Lo sentimos! Hay un problema de conexión para completar tu solicitud.');
INSERT INTO error_matrix VALUES ('BC-CA-102', '1', '¡Lo sentimos! Hay un problema de conexión para completar tu solicitud.');
INSERT INTO error_matrix VALUES ('BC-CA-900', '2', '¡Lo sentimos!Tu solicitud de tu Tarjeta de Crédito ha sido rechazada.');
INSERT INTO error_matrix VALUES ('BS-DI-100', '3', '¡Lo sentimos! Hay un problema de conexión para completar tu solicitud.');

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS status;
CREATE TABLE status (
  status_id varchar(255) COLLATE pg_catalog.default NOT NULL,
  status_name varchar(255) COLLATE pg_catalog.default NOT NULL,
  description varchar(255) COLLATE pg_catalog.default NOT NULL
)
;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO status VALUES ('1', 'En revision', 'Aquellos errores que no generan folio');
INSERT INTO status VALUES ('2', 'Rechazada', 'Se debe bloquear el acceso a la app');
INSERT INTO status VALUES ('3', 'En proceso', 'Genera folio pero aun no se aprueba la solicitud');
INSERT INTO status VALUES ('4', 'Aprobada', 'Cuando una solicitud es aptrobada');

-- ----------------------------
-- Primary Key structure for table error_matrix
-- ----------------------------
ALTER TABLE error_matrix ADD CONSTRAINT error_matrix_pkey PRIMARY KEY (error_code);

-- ----------------------------
-- Primary Key structure for table status
-- ----------------------------
ALTER TABLE status ADD CONSTRAINT status_pkey PRIMARY KEY (status_id);

-- ----------------------------
-- Foreign Keys structure for table error_matrix
-- ----------------------------
ALTER TABLE error_matrix ADD CONSTRAINT status_id FOREIGN KEY (status) REFERENCES status (status_id) ON DELETE NO ACTION ON UPDATE NO ACTION;
