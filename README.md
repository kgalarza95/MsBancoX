# MsBancoX
Microservicios y objetos para gestión de procesos bancarios

# Sistema de Gestión Bancaria - Microservicios de Clientes y Cuentas/Movimientos

Este proyecto contiene dos microservicios desarrollados con **Spring Boot** y **JPA**, que gestionan la información de **clientes** y **cuentas/movimientos** en una arquitectura de microservicios.

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes componentes:

- **Java 17**: Necesario para compilar y ejecutar los microservicios.
- **MySQL**: Base de datos relacional que se utiliza para persistir la información.
- **Maven 3.6+**: Para gestionar dependencias y compilar el proyecto.

## Configuración de Base de Datos

1. **Instalar MySQL**: Asegúrate de tener MySQL instalado en tu sistema.

2. **Crear el esquema de base de datos**:

   Debes crear un esquema llamado `banco_x` y un usuario con todos los permisos necesarios:

   ```sql
   CREATE DATABASE banco_x;

   CREATE USER 'gestion_bancaria'@'localhost' IDENTIFIED BY 'tu_password';

   GRANT ALL PRIVILEGES ON banco_x.* TO 'gestion_bancaria'@'localhost';

   FLUSH PRIVILEGES;
