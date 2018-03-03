/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  georg
 * Created: 2/03/2018
 */
CREATE DATABASE calculadora
  WITH OWNER = elusuario
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Spanish_Colombia.1252'
       LC_CTYPE = 'Spanish_Colombia.1252'
       CONNECTION LIMIT = -1;

CREATE TABLE Producto
(
	id serial primary key,
	nombre text, 
	categoria text, 
	precio double precision
)

ALTER TABLE producto
  OWNER TO elusuario;