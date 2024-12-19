Fridge Fresh
Descripción
Fridge Fresh es una aplicación diseñada para ayudar a los usuarios a gestionar sus listas de compras y el inventario de su refrigerador de manera eficiente. Proporciona herramientas intuitivas para organizar, mover y monitorear productos, con un énfasis especial en el control de fechas de vencimiento y cantidades.
Características principales:
Creación y gestión de listas de compras personalizadas.
Transferencia de productos entre listas.
Almacenamiento de productos comprados en un contenedor centralizado.
Notificaciones sobre productos que están por vencer.
Modo offline para todas las funciones excepto el registro e inicio de sesión.

Instalación
Requisitos previos:
Android Studio (versión recomendada: 2024.1 o superior).
JDK (Java Development Kit).
Un dispositivo Android o emulador configurado.
Pasos de instalación:
Clona este repositorio:
git clone https://github.com/Danilepez/ProyectoPrograIII.git
Abre el proyecto en Android Studio.
Sincroniza el proyecto con Gradle.
Configura un emulador Android o conecta un dispositivo físico.
Compila y ejecuta la aplicación.

Uso
Pantalla principal
Al iniciar sesión o registrarse, el usuario es llevado a la pantalla principal, donde encontrará las siguientes opciones:
Listas
Permite gestionar las listas de compras.
Cada lista contiene productos con los siguientes atributos:
Nombre
Cantidad
Fecha de vencimiento (opcional)
Acciones disponibles:
Botón "+": Crear una nueva lista.
Botón "-": Eliminar listas existentes.
Ingresar a una lista: Ver productos y realizar las siguientes acciones:
Chequear: Mover productos comprados al contenedor.
Modificar: Añadir o eliminar productos en la lista.
Combinar: Transferir productos seleccionados a otra lista.
Contenedor
Almacena los productos comprados desde las listas.
Incluye información detallada como:
Cantidad
Fecha de vencimiento
Origen (lista de donde proviene el producto)
Modos de visualización:
Vista compacta: Muestra solo los nombres de los productos.
Vista detallada: Muestra todos los detalles de los productos.
Modificar: Permite agregar productos directamente al contenedor o editar los existentes.
Vencen pronto
Se divide en dos listas:
Vencen pronto: Productos con fecha de vencimiento dentro de los próximos 3 días.
Vencidos: Productos cuya fecha de vencimiento ya pasó.
Ambos apartados muestran el nombre del producto y su fecha de vencimiento.



Tecnologías Usadas
Lenguaje: Kotlin, xml
IDE: Android Studio
Bases de datos: SQLite (almacenamiento offline)

Autores
Diego Gomez
Daniel Lopez
