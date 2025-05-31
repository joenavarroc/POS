-- Active: 1742437067050@@127.0.0.1@3306@pos
-- Crear la base de datos
DROP DATABASE pos;
CREATE DATABASE IF NOT EXISTS pos;
USE pos;
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
-- Cambio de contraseña (si es necesario)
ALTER USER 'root'@'localhost' IDENTIFIED BY '1234';

-- Crear tabla negocio (Empresa)
CREATE TABLE negocio (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL
);

-- Crear tabla cliente (Usuarios del sistema)
CREATE TABLE cliente (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,  -- Cambio de SERIAL a INT UNSIGNED AUTO_INCREMENT
  nombre VARCHAR(100) NOT NULL,
  email VARCHAR(150) UNIQUE NOT NULL,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  negocio_id INT UNSIGNED NOT NULL,  -- Aseguramos que negocio_id sea INT UNSIGNED
  FOREIGN KEY (negocio_id) REFERENCES negocio(id) ON DELETE CASCADE
);

-- Crear tabla categoria (Categorías de productos)
CREATE TABLE categoria (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  imagen TEXT
);

-- Crear tabla producto (Productos)
CREATE TABLE producto (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  precio DECIMAL(10, 2) NOT NULL,
  imagen TEXT,
  stock INT NOT NULL DEFAULT 0,
  categoria_id INT UNSIGNED NOT NULL,  -- Referencia a categoria
  negocio_id INT UNSIGNED NOT NULL,   -- Referencia a negocio
  FOREIGN KEY (categoria_id) REFERENCES categoria(id) ON DELETE CASCADE,
  FOREIGN KEY (negocio_id) REFERENCES negocio(id) ON DELETE CASCADE
);

-- Crear tabla venta
CREATE TABLE venta (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  fecha DATETIME NOT NULL,
  metodo_pago VARCHAR(50) NOT NULL,
  total DECIMAL(10, 2) NOT NULL,
  negocio_id INT UNSIGNED NOT NULL,
  FOREIGN KEY (negocio_id) REFERENCES negocio(id) ON DELETE CASCADE
);

-- Crear tabla detalle_venta
CREATE TABLE detalle_venta (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  venta_id INT UNSIGNED NOT NULL,
  producto_id INT UNSIGNED NOT NULL,
  cantidad INT NOT NULL,
  subtotal DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (venta_id) REFERENCES venta(id) ON DELETE CASCADE,
  FOREIGN KEY (producto_id) REFERENCES producto(id) ON DELETE CASCADE
);

-- Crear tabla cierre_diario
CREATE TABLE cierre_diario (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  fecha DATE NOT NULL,
  total DECIMAL(10, 2) NOT NULL,
  negocio_id INT UNSIGNED NOT NULL,  -- Agregar referencia al negocio
  FOREIGN KEY (negocio_id) REFERENCES negocio(id) ON DELETE CASCADE
);
