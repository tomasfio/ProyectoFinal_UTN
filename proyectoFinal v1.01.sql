-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto_final
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `almacenes`
--

DROP TABLE IF EXISTS `almacenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `almacenes` (
  `idAlmacen` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) NOT NULL,
  `localidad` varchar(45) NOT NULL,
  PRIMARY KEY (`idAlmacen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacenes`
--

LOCK TABLES `almacenes` WRITE;
/*!40000 ALTER TABLE `almacenes` DISABLE KEYS */;
/*!40000 ALTER TABLE `almacenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categorias` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Lactios','Productos derivados de la leche'),(2,'Alfajores','Alfajores');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entregas`
--

DROP TABLE IF EXISTS `entregas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `entregas` (
  `idEntregas` int(11) NOT NULL AUTO_INCREMENT,
  `fechaSalida` datetime DEFAULT NULL,
  `fechaFinalizada` datetime DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `idTransportista` int(11) NOT NULL,
  PRIMARY KEY (`idEntregas`),
  KEY `FK_Transportista_Entrega_idx` (`idTransportista`),
  CONSTRAINT `FK_Transportista_Entrega` FOREIGN KEY (`idTransportista`) REFERENCES `transportistas` (`idtransportistas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entregas`
--

LOCK TABLES `entregas` WRITE;
/*!40000 ALTER TABLE `entregas` DISABLE KEYS */;
/*!40000 ALTER TABLE `entregas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entregas_detalles`
--

DROP TABLE IF EXISTS `entregas_detalles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `entregas_detalles` (
  `idEntregaDetalles` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) NOT NULL,
  `fechaEntrega` datetime DEFAULT NULL,
  `idEntrega` int(11) NOT NULL,
  PRIMARY KEY (`idEntregaDetalles`),
  KEY `FK_Detalle_Entrega_idx` (`idEntrega`),
  CONSTRAINT `FK_Detalle_Entrega` FOREIGN KEY (`idEntrega`) REFERENCES `entregas` (`identregas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entregas_detalles`
--

LOCK TABLES `entregas_detalles` WRITE;
/*!40000 ALTER TABLE `entregas_detalles` DISABLE KEYS */;
/*!40000 ALTER TABLE `entregas_detalles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lotes`
--

DROP TABLE IF EXISTS `lotes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lotes` (
  `idLote` int(11) NOT NULL AUTO_INCREMENT,
  `fechaIngreso` datetime NOT NULL,
  `vencimiento` datetime NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precioCompra` double NOT NULL,
  `estado` varchar(45) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `idMovimiento` int(11) NOT NULL,
  `idPosicion` int(11) NOT NULL,
  PRIMARY KEY (`idLote`),
  KEY `FK_Lote_Producto_idx` (`idProducto`),
  KEY `FK_Lote_Posicion_idx` (`idPosicion`),
  KEY `FK_Lote_Movimiento_idx` (`idMovimiento`),
  CONSTRAINT `FK_Lote_Movimiento` FOREIGN KEY (`idMovimiento`) REFERENCES `movimientos` (`idmovimiento`),
  CONSTRAINT `FK_Lote_Posicion` FOREIGN KEY (`idPosicion`) REFERENCES `posiciones` (`idposicion`),
  CONSTRAINT `FK_Lote_Producto` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lotes`
--

LOCK TABLES `lotes` WRITE;
/*!40000 ALTER TABLE `lotes` DISABLE KEYS */;
/*!40000 ALTER TABLE `lotes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `marcas` (
  `idMarca` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (1,'La serrenisima','Empresa de productos lactios y derivados');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movimientos` (
  `idMovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `observacion` varchar(200) DEFAULT NULL,
  `importe` double NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idEntregaDetalle` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMovimiento`),
  KEY `FK_Detalle_Movimiento_idx` (`idEntregaDetalle`),
  KEY `FK_Detalle_Usuario_idx` (`idUsuario`),
  CONSTRAINT `FK_Detalle_Movimiento` FOREIGN KEY (`idEntregaDetalle`) REFERENCES `entregas_detalles` (`identregadetalles`),
  CONSTRAINT `FK_Detalle_Usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (1,'2019-03-05 03:28:47','Saavedra 1967','',87.6,2,NULL),(2,'2019-03-05 03:29:51','Saavedra 1967','',87.6,2,NULL),(3,'2019-03-05 03:36:55','Entre rios 1123','No mandarlo de tarde',25.6,2,NULL),(4,'2019-03-05 03:40:43','Saavedra 1967','',25.6,2,NULL);
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movistock`
--

DROP TABLE IF EXISTS `movistock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movistock` (
  `idMovistock` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `subTotal` double NOT NULL,
  `idMovimiento` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  PRIMARY KEY (`idMovistock`),
  KEY `FK_Movimiento_Movistock_idx` (`idMovimiento`),
  KEY `FK_Producto_Movistock_idx` (`idProducto`),
  CONSTRAINT `FK_Movimiento_Movistock` FOREIGN KEY (`idMovimiento`) REFERENCES `movimientos` (`idmovimiento`),
  CONSTRAINT `FK_Producto_Movistock` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movistock`
--

LOCK TABLES `movistock` WRITE;
/*!40000 ALTER TABLE `movistock` DISABLE KEYS */;
INSERT INTO `movistock` VALUES (1,2,51.2,2,1),(2,1,36.4,2,2),(3,1,25.6,3,1),(4,1,25.6,4,1);
/*!40000 ALTER TABLE `movistock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movistock_lotes`
--

DROP TABLE IF EXISTS `movistock_lotes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movistock_lotes` (
  `idMovistockLote` int(11) NOT NULL AUTO_INCREMENT,
  `idLote` int(11) NOT NULL,
  `idMovistock` int(11) NOT NULL,
  PRIMARY KEY (`idMovistockLote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movistock_lotes`
--

LOCK TABLES `movistock_lotes` WRITE;
/*!40000 ALTER TABLE `movistock_lotes` DISABLE KEYS */;
/*!40000 ALTER TABLE `movistock_lotes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofertas`
--

DROP TABLE IF EXISTS `ofertas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ofertas` (
  `idOferta` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `descuento` double NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `idProducto` int(11) NOT NULL,
  PRIMARY KEY (`idOferta`),
  KEY `FK_Oferta_Producto_idx` (`idProducto`),
  CONSTRAINT `FK_Oferta_Producto` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofertas`
--

LOCK TABLES `ofertas` WRITE;
/*!40000 ALTER TABLE `ofertas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ofertas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posiciones`
--

DROP TABLE IF EXISTS `posiciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `posiciones` (
  `idPosicion` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) NOT NULL,
  `idAlmacen` int(11) NOT NULL,
  PRIMARY KEY (`idPosicion`),
  KEY `FK_Almacen_Posicion_idx` (`idAlmacen`),
  CONSTRAINT `FK_Almacen_Posicion` FOREIGN KEY (`idAlmacen`) REFERENCES `almacenes` (`idalmacen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posiciones`
--

LOCK TABLES `posiciones` WRITE;
/*!40000 ALTER TABLE `posiciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `posiciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `precioUnidad` double NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `idMarca` int(11) NOT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `FK_Marca_Producto_idx` (`idMarca`),
  KEY `FK_Producto_Categoria_idx` (`idCategoria`),
  CONSTRAINT `FK_Producto_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`idcategoria`),
  CONSTRAINT `FK_Producto_Marca` FOREIGN KEY (`idMarca`) REFERENCES `marcas` (`idmarca`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Prueba 1','Producto de prueba',25.6,1,1),(2,'Prueba 2','Producto de prueba 2',36.4,1,1);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos_proveedores`
--

DROP TABLE IF EXISTS `productos_proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productos_proveedores` (
  `idProductoProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `idProducto` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  PRIMARY KEY (`idProductoProveedor`),
  KEY `FK_PP_Proveedor_idx` (`idProveedor`),
  KEY `FK_PP_Producto_idx` (`idProducto`),
  CONSTRAINT `FK_PP_Producto` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idproducto`),
  CONSTRAINT `FK_PP_Proveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedores` (`idproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos_proveedores`
--

LOCK TABLES `productos_proveedores` WRITE;
/*!40000 ALTER TABLE `productos_proveedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos_proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proveedores` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transportistas`
--

DROP TABLE IF EXISTS `transportistas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transportistas` (
  `idTransportistas` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `vehiculo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTransportistas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transportistas`
--

LOCK TABLES `transportistas` WRITE;
/*!40000 ALTER TABLE `transportistas` DISABLE KEYS */;
/*!40000 ALTER TABLE `transportistas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `fechaAlta` datetime NOT NULL,
  `tipoUsuario` int(11) NOT NULL,
  `anulado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'tomasfio','12345678','Tomas','Fiorenza','San lorenzo','03476 #######','03476 15698234','tomas4fiorenza@gmail.com','2018-12-20 04:38:11',0,0),(2,'julboquita','87654321','Pablo','Perna','San lorenzo','03476 #######','03476 15698234','julian@gmail.com','2018-12-20 04:38:35',1,0);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-05 15:52:33
