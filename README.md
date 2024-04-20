# Proyecto
## Descripción
Web app diseñada para llevar el control de horarios laborales y  para realizar el calculo de pago de nomina de acuerdo con el horario acordado, se descontara del calculo si el colaborador no completo su jornada laboral.

## Problema
Los colaboradores en ocasiones presentan quejas con respecto a sus permisos de salida y sus vacaciones, el dueño del negocio lleva un control en una hoja de papel que es facil de manipular y actualmente no cuenta con una herramienta automatizada para poder comprobar a sus colabordadores los días de vacaciones y el motivo de que no se le de el pago completo de su servicio por incumplimiento de horas.

## Solución
Se desarrolla una Web App para que lleve el control automatico, donde el usuario tendra un gafete que escaneara en el sistema, y este, almacenara los registros para que al final de la semana, el dueño del negocio pueda obtener un resumen de las horas laboradas por sus empleados.

## Arquitectura
 ![Imagen1](https://github.com/Th33J0k33r/PagoNomina/assets/158702084/e2dc221a-f46d-4966-9fad-109848fb9bf8)
 
## Tabla de Contenidos
 - [Requerimientos](https://github.com/Th33J0k33r/PagoNomina/blob/main/README.md#requerimientos)
 - [Instalación](https://github.com/Th33J0k33r/PagoNomina/blob/main/README.md#instalaci%C3%B3n)
 - [Uso](https://github.com/Th33J0k33r/PagoNomina/blob/main/README.md#uso)
 - [Contribución](https://github.com/Th33J0k33r/PagoNomina/blob/main/README.md#contribuci%C3%B3n)
 - [Roadmap](https://github.com/Th33J0k33r/PagoNomina/blob/main/README.md#roadmap)
 
### Requerimientos
- Servidor MySQL Workbench
- Ultima Version de Java
- Base de datos dbnomina
- Libreria: mysql-connector-java-5.1.15
- JDK21

### Instalación
1. Se debe descargar MySQL WrokBrench 6.2
  - https://dev.mysql.com/doc/workbench/en/wb-mysql-connections-navigator-management-users-and-privileges.html
2. Ambiente de desarrollo, se deben tener la base de datos dbnomina y las tablas de bitacora y usuarios
  - Generar Base de Datos dbnomina
     Se puede usar el siguiente comando: `SELECT * FROM CREATE DATABASE `dbnomina` /*!40100 DEFAULT CHARACTER SET utf8 */; `
  - Generar tabla de usuarios
       `CREATE TABLE `bitacora` (
       `idbitacora` int(11) NOT NULL AUTO_INCREMENT,
       `idempleado` varchar(10) DEFAULT NULL,
       `tiporegistro` int(11) DEFAULT NULL,
       `fecharegistro` date DEFAULT NULL,
       `horaregistro` time DEFAULT NULL,
       `horasalida` time DEFAULT NULL,
       `diferencia` decimal(5,2) DEFAULT NULL,
       PRIMARY KEY (`idbitacora`)
       ) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;`
  - Generar tabla de bitacora
        `CREATE TABLE `usuarios` (
        `idusuarios` int(11) NOT NULL AUTO_INCREMENT,
        `idempleado` varchar(10) NOT NULL,
        `nombre` varchar(45) DEFAULT NULL,
        `usuario` varchar(20) DEFAULT NULL,
        `password` varchar(45) DEFAULT NULL,
        PRIMARY KEY (`idusuarios`,`idempleado`)
        ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;`

3. Pruebas manualmente
   Se debe ingresar al menos un usuario, este usuario sera el administrador, el cual tendra acceso a los registros de todos los empleados
4. Implementar la solución en producción en un ambiente local
   Una vez realizada la configuracion anteriror, se puede ejecutar el WRAR

### Configuración
1. Configuración del producto (archivos de configuración)
    - Se debera instalar la base de datos y laa tablas en el servidor local
2. Configuración de los requerimientos
    - El usuario administrador debe contar con un registro  en la base de datos de usuario para poder realizar la administracion

### Uso
**Manual que se hará referencia para usuarios finales.**
Registro de asistencia:
Los colaboradores veran una pantalla en la que deberan ingresar (o escanear) su numero de empleado e indicar si es un registro de entrada o de salida, una vez seleccionada esta opcion, se pulsara el boton enviar.

**Sección de referencia para usuario administrador.**
Administracion de Asistencia:
1. El dueño del negocio, debera contar con un usuario y contraseña
2. Debe realizar su registro de manera normal
3. Aparecera una pantalla en donde se le solicitara su usuario y contraseña
4. Se podra ingresar a la bitacora de empelados

### Contribución
1. El proyecto cuenta con dos branch principales (Develop, Main)
2. Todos los desarrollos iniciales deben de ingresrarse en el branch de Develop, y una vez terminadas las modificaciones, se debera hacer un marge con main
     - Hacer una tarea y un branch por cada fase del desarrollo
     - Ingresar a GitHub
     - Seleccionar branch developer
     - Selecicionar boton "New Branch"
     - Ingresar el nombre de la tarea a ralizar en el campo del nombre y seleccionar la fuente Developer
     - Una vez que se haya realizado un cambio en el proyecto, se debera solicitar un pull request desde la app de sscritorio, donde se cerrara la tarea deseada y se le pondra un breve comentario del cambio efectuado en el campo de descripcion.
   
 
### Roadmap
- Termino de Web App para poder realizar el calculo del pago final
- Modulo para editar/agregar usuarios
- Modulo para solicitar vacaciones
