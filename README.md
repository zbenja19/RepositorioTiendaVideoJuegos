# RepositorioTiendaVideoJuegos

# Integrantes del Proyecto
1. **Benjamín Trujillo**
2. **Matías Oviedo**
3. **Karol Carrasco**

## Descripción del proyecto
Este proyecto consiste en el desarrollo de una tienda virtual de videojuegos digitales, diseñada para ofrecer a los usuarios una experiencia de navegación intuitiva y dinámica. La plataforma cuenta con un catálogo inteligente organizado por categorías y géneros, lo que permite a los jugadores explorar, filtrar y encontrar sus títulos favoritos de manera rápida y sencilla. El objetivo principal es fusionar un diseño visual atractivo con un sistema de orden eficiente que mantenga la tienda siempre estructurada y fácil de usar.

## Listado de Microservicios Implementados 
1. **Registro de Usuarios**
2. **Pedidos y detalle de pedidos**
3. **Ofertas y detalles de ofertas**
4. **Metodos de pago**
5. **Plataforma de los video juegos**
6. **Proveedores**
7. **Biblioteca de video juegos**

## Rutas principales del Gateway
1. **Usuario** | "/api/v1/clientes" | GET | Listar a todos los clientes y buscar alguno en especifico por su id.
2. **Videojuegos** | "/api/v1/Videojuegos" | GET | Listar video juegos de la tienda y buscar por id o categoría.
3. **Pedidos** | "/api/v1/pedidos/" | GET | Listar los pedidos realizados.
4. **Ofertas** | ""/api/v1/ofertas" | POST | Agregar nuevas ofertas de video juegos dentro de la tienda.
5. **Biblioteca** | "/api/v1/biblioteca" | POST | Agregar nuevos video juegos dentro de la biblioteca.
6. **Pago** | "/api/v1/pagos" | POST | Agregar metodos de pago.
7. **Proveedor** | "/api/v1/proveedor" | PUT | Actualizar datos del proveedor.   
