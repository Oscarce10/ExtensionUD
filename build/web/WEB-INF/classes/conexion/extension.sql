-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-03-2020 a las 02:14:33
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `extension`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aspirante`
--

CREATE TABLE `aspirante` (
  `idaspirante` int(11) NOT NULL,
  `uuid` blob DEFAULT NULL,
  `primer_nombre` varchar(150) DEFAULT NULL,
  `segundo_nombre` varchar(150) DEFAULT NULL,
  `primer_apellido` varchar(150) DEFAULT NULL,
  `segundo_apellido` varchar(150) DEFAULT NULL,
  `numero_documento` varchar(200) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `telefono_fijo` varchar(150) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `foto` varchar(200) DEFAULT NULL,
  `Descripcion` varchar(10000) DEFAULT NULL,
  `hoja_de_vida` varchar(250) DEFAULT NULL,
  `correo` varchar(200) DEFAULT NULL,
  `clave` varchar(200) DEFAULT NULL,
  `salt` blob DEFAULT NULL,
  `tipo_documento` int(11) NOT NULL,
  `nacionalidad` int(11) NOT NULL,
  `ciudad_residencia` int(11) NOT NULL,
  `sexo` int(11) NOT NULL,
  `profesion` int(11) NOT NULL,
  `formacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad_residencia`
--

CREATE TABLE `ciudad_residencia` (
  `id` int(11) NOT NULL,
  `ciudad_residencia` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coordinador`
--

CREATE TABLE `coordinador` (
  `idcoordinador` int(11) NOT NULL,
  `uuid` blob DEFAULT NULL,
  `primer_nombre` varchar(150) DEFAULT NULL,
  `segundo_nombre` varchar(150) DEFAULT NULL,
  `primer_apellido` varchar(150) DEFAULT NULL,
  `segundo_apellido` varchar(150) DEFAULT NULL,
  `correo` varchar(50) NOT NULL,
  `clave` varchar(200) DEFAULT NULL,
  `salt` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `coordinador`
--

INSERT INTO `coordinador` (`idcoordinador`, `uuid`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `correo`, `clave`, `salt`) VALUES
(4, 0x9dace6c9aedb4cf799eeb1ab2e7316a2, 'Oscar', '', 'Cely', '', '1@c.com', '89EC18992DDDA8E0CED302A682FD44D4090CA4DDEA870493C4D17777D851D4C3', 0xe429a3fc6634bfea2f8888f9e3c2b89aba57348c);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formacion`
--

CREATE TABLE `formacion` (
  `id` int(11) NOT NULL,
  `tipo_de_formacion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nacionalidad`
--

CREATE TABLE `nacionalidad` (
  `id` int(11) NOT NULL,
  `nacionalidad` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesion`
--

CREATE TABLE `profesion` (
  `id` int(11) NOT NULL,
  `profesion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sexo`
--

CREATE TABLE `sexo` (
  `id` int(11) NOT NULL,
  `sexo` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_documento`
--

CREATE TABLE `tipo_documento` (
  `id` int(11) NOT NULL,
  `tipo_documento` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aspirante`
--
ALTER TABLE `aspirante`
  ADD PRIMARY KEY (`idaspirante`,`tipo_documento`,`nacionalidad`,`ciudad_residencia`,`sexo`,`profesion`,`formacion`),
  ADD KEY `fk_aspirante_tipo_documento_idx` (`tipo_documento`),
  ADD KEY `fk_aspirante_nacionalidad1_idx` (`nacionalidad`),
  ADD KEY `fk_aspirante_ciudad_residencia1_idx` (`ciudad_residencia`),
  ADD KEY `fk_aspirante_sexo1_idx` (`sexo`),
  ADD KEY `fk_aspirante_profesion1_idx` (`profesion`),
  ADD KEY `fk_aspirante_formacion1_idx` (`formacion`);

--
-- Indices de la tabla `ciudad_residencia`
--
ALTER TABLE `ciudad_residencia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `coordinador`
--
ALTER TABLE `coordinador`
  ADD PRIMARY KEY (`idcoordinador`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indices de la tabla `formacion`
--
ALTER TABLE `formacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `nacionalidad`
--
ALTER TABLE `nacionalidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `profesion`
--
ALTER TABLE `profesion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `sexo`
--
ALTER TABLE `sexo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aspirante`
--
ALTER TABLE `aspirante`
  MODIFY `idaspirante` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ciudad_residencia`
--
ALTER TABLE `ciudad_residencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `coordinador`
--
ALTER TABLE `coordinador`
  MODIFY `idcoordinador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `profesion`
--
ALTER TABLE `profesion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sexo`
--
ALTER TABLE `sexo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aspirante`
--
ALTER TABLE `aspirante`
  ADD CONSTRAINT `fk_aspirante_ciudad_residencia1` FOREIGN KEY (`ciudad_residencia`) REFERENCES `ciudad_residencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_aspirante_formacion1` FOREIGN KEY (`formacion`) REFERENCES `formacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_aspirante_nacionalidad1` FOREIGN KEY (`nacionalidad`) REFERENCES `nacionalidad` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_aspirante_profesion1` FOREIGN KEY (`profesion`) REFERENCES `profesion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_aspirante_sexo1` FOREIGN KEY (`sexo`) REFERENCES `sexo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_aspirante_tipo_documento` FOREIGN KEY (`tipo_documento`) REFERENCES `tipo_documento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
