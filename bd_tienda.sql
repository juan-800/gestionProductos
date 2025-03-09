-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-03-2025 a las 00:02:19
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_tienda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` bigint(20) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `descripcion` varchar(60) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `cantidad`, `descripcion`, `nombre`, `precio`) VALUES
(3, 1, 'vitaminas', 'calcio', 20000),
(4, 3, 'vitaminas', 'collagenos', 10000),
(5, 5, 'suplemento', 'Ashawanda', 60000),
(8, 2, 'suplemento', 'Ashawanda', 30000),
(9, 1, 'vitaminass', 'Ashawanda', 20000),
(10, 10, 'te', 'te relax', 70000),
(11, 2, 'vitaminas', 'vitamina E', 20000),
(12, 2, 'suplemento', 'alcachofa', 15000),
(13, 2, 'vitaminass', 'te relax', 10000),
(14, 1, 'suplemento', 'magnesio', 11000),
(15, 3, 'suplemento', 'toro vital', 150000),
(16, 2, 'suplemento', 'vital plus', 130000),
(17, 28, 'vitaminass', 'vitamina k', 25000),
(18, 20, 'agregando producto', 'ensayo', 150000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
