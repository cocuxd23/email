# Gestor de Correos Electrónicos - Desarrollo TDD

[![Java CI with Maven](https://github.com/felix-toledo/gestorMails-tdd-java/actions/workflows/maven.yml/badge.svg)](https://github.com/felix-toledo/gestorMails-tdd-java/actions/workflows/maven.yml)
[![codecov](https://codecov.io/gh/felix-toledo/gestorMails-tdd-java/graph/badge.svg?token=GFJTFBHX9F)](https://codecov.io/gh/felix-toledo/gestorMails-tdd-java)

Este proyecto es un Gestor de Correos Electrónicos desarrollado siguiendo la metodología de Desarrollo Dirigido por Pruebas (TDD). A continuación, se detallan los requisitos y funcionalidades del sistema.

## Funcionalidades

### Creación de Correos Electrónicos
- [X] Los correos electrónicos deben tener las siguientes propiedades: Asunto, Contenido, Remitente (un solo contacto) y Para (múltiples contactos).

### Envío de Correos Electrónicos
- [X] Un usuario puede enviar un correo a múltiples contactos al especificar varios destinatarios en el campo "Para".
- [X] Cuando un usuario envía un correo, este debe ser almacenado en la Bandeja de Enviados del emisor y la de recibidos del remitente.

### Gestión de Contactos
- [X] Un "Contacto" es un objeto que contiene información de Nombre de la persona y Email de dicha persona. Se utiliza para especificar el remitente o los destinatarios en el campo "Para".

### Filtros
- [X] Los usuarios deben poder crear filtros para organizar sus correos electrónicos.
- [X] Los filtros son carpetas que no contienen correos, sino que filtran correos en base a elementos del email, como parte del asunto, parte del contenido, remitente o destinatarios en el campo "Para".
- [X] Los filtros deben tener un nombre descriptivo, como "Correos de la UCP".
- [X] La aplicación debe ser capaz de gestionar al menos 5 filtros.
- [X] De estos 5 filtros, al menos 2 o 3 de ellos deben ser complejos, es decir, deben poder buscar correos en función de 2 o más campos simultáneamente (por ejemplo, asunto y remitente).

### Búsqueda de Correos
- [X] Los usuarios pueden buscar correos en una bandeja.
- [X] Busqueda sobre asunto.
- [X] Busqueda sobre remitente.
- [X] Busqueda sobre mensaje.
- [X] Busqueda sobre asunto + mensaje.
- [X] Busqueda sobre asunto + remitente.

### Creación de Usuario
- [X] La aplicación debe permitir que los usuarios se registren y creen cuentas de usuario.
- [X] Para crear un usuario, se deben recopilar y almacenar información básica, como nombre, apellido y dirección de correo electrónico.
- [X] Cada usuario debe tener su propio espacio de trabajo y bandeja de entrada privada para gestionar sus correos electrónicos y filtros personalizados.

