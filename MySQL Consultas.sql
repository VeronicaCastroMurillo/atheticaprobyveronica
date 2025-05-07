-- Creación de Base de Datos con aceptación de caracteres especiales
CREATE DATABASE AthleticProByVeronica
CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE AthleticProByVeronica;

-- Tabla de Categorias
CREATE TABLE Categoria (
    Id INT AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Descripcion TEXT,
    CONSTRAINT PK_Categoria PRIMARY KEY (Id)
);

-- Tabla de Productos
CREATE TABLE Producto (
    Id INT AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Descripcion TEXT,
	IdCategoria INT,
    Precio DECIMAL(10,2) NOT NULL,
    Cantidad INT NOT NULL,
    CONSTRAINT PK_Producto PRIMARY KEY (Id),
    CONSTRAINT FK_Prod_Cate FOREIGN KEY (IdCategoria) REFERENCES Categoria(Id) ON DELETE CASCADE
);

-- Tabla de Permisos
CREATE TABLE Permiso (
	Id INT AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    CONSTRAINT PK_Permiso PRIMARY KEY (Id)
);

-- Tabla de Usuarios
CREATE TABLE Usuario (
    Id INT AUTO_INCREMENT,
    Cedula VARCHAR(15) NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Correo VARCHAR(100) NOT NULL,
    Contraseña VARCHAR(255) NOT NULL,
    IdPermiso INT,
    Telefono VARCHAR(15),
    Direccion TEXT,
    Activo BIT,
    CONSTRAINT PK_Usuario PRIMARY KEY (Id),
    CONSTRAINT FK_Usua_Perm FOREIGN KEY (IdPermiso) REFERENCES Permiso(Id) ON DELETE CASCADE
);

-- Tabla de Facturas
CREATE TABLE Factura (
    Id INT AUTO_INCREMENT,
    Fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    IdUsuario INT,
    MetodoPago VARCHAR(15) NOT NULL,
    MontoPagado DECIMAL(10,2),
    PrecioNeto DECIMAL(10,2),
    Descuento DECIMAL(10,2),
    Impuesto DECIMAL(10,2),
    PrecioTotal DECIMAL(10,2),
	CONSTRAINT PK_Factura PRIMARY KEY (Id),
    CONSTRAINT FK_Fact_Usua FOREIGN KEY (IdUsuario) REFERENCES Usuario(Id) ON DELETE CASCADE
);

-- Tabla de Detalles de Facturas
CREATE TABLE DetalleFactura (
    Id INT AUTO_INCREMENT,
    IdFactura INT,
    IdProducto INT,
    Cantidad INT,
    PrecioUnitario DECIMAL(10,2),
    CONSTRAINT PK_DetalleFactura PRIMARY KEY (Id),
    CONSTRAINT FK_DeFa_Fact FOREIGN KEY (IdFactura) REFERENCES Factura(Id) ON DELETE CASCADE,
    CONSTRAINT FK_DeFa_Prod FOREIGN KEY (IdProducto) REFERENCES Producto(Id) ON DELETE CASCADE
);



