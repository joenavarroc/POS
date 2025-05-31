-- Active: 1742437067050@@127.0.0.1@3306@pos
-- ******************************************Cafetería Coffee Store******************************
-- Inserción de negocio
INSERT INTO negocio (nombre) VALUES 
('Cafetería Coffee Store'),
('Ferreteria Buloneando');

-- Inserción de cliente
INSERT INTO cliente (nombre, email, username, password, negocio_id)VALUES 
('Juan Pérez', 'juan@example.com', 'juanp', 'password123', 1), 
('Sergio Ramos', 'sergio@example.com', 'sergior', 'password456', 2);

-- Inserción de categorías
INSERT INTO categoria (id, nombre, imagen) VALUES
(1, 'Cafe', 'https://cdn.pixabay.com/photo/2014/12/11/02/56/coffee-563797_1280.jpg'),
(2, 'Panaderia', 'https://cdn.pixabay.com/photo/2019/03/14/06/37/bread-4054286_960_720.jpg'),
(3, 'Jugos', 'https://cdn.pixabay.com/photo/2016/10/09/14/00/vegetable-juices-1725835_960_720.jpg'),
(4, 'Lunch', 'https://cdn.pixabay.com/photo/2022/02/11/07/03/bento-7006665_960_720.jpg'),
(5, 'Postres', 'https://cdn.pixabay.com/photo/2014/08/26/12/49/the-cake-427920_1280.jpg'),
(6, 'Merienda', 'https://cdn.pixabay.com/photo/2019/07/14/01/31/bagel-sandwich-4336042_960_720.jpg'),
(7, 'Desayunos', 'https://cdn.pixabay.com/photo/2015/08/20/20/07/cereal-898073_1280.jpg'),
(8, 'Varios', 'https://cdn.pixabay.com/photo/2017/04/25/08/04/coffee-beans-2258852_960_720.jpg');

-- Inserción de productos
INSERT INTO producto (nombre, precio, imagen, stock, categoria_id, negocio_id) VALUES 
('Expreso', 300, 'https://cdn.pixabay.com/photo/2017/09/04/18/39/coffee-2714970_960_720.jpg', 50, 1, 1),
('Latte', 300, 'https://cdn.pixabay.com/photo/2022/04/15/09/14/coffee-7133980_1280.jpg', 45, 1, 1),
('Te', 2500, 'https://cdn.pixabay.com/photo/2016/10/14/18/21/tee-1740871_1280.jpg', 30, 1, 1),
('Chocolate', 2000, 'https://cdn.pixabay.com/photo/2015/11/23/11/57/hot-chocolate-1058197_1280.jpg', 25, 1, 1),
('Frape', 2000, 'https://cdn.pixabay.com/photo/2020/03/07/05/18/beverage-4908765_1280.jpg', 20, 1, 1),
('Medialuna', 250, 'https://cdn.pixabay.com/photo/2018/11/24/23/46/croissant-3836578_1280.jpg', 60, 2, 1),
('Muffin', 350, 'https://cdn.pixabay.com/photo/2020/03/06/03/25/red-velvet-cake-4905933_1280.jpg', 40, 2, 1),
('Cookie', 200, 'https://cdn.pixabay.com/photo/2015/08/12/17/23/pastries-886098_960_720.jpg', 35, 2, 1),
('Scone', 3000, 'https://cdn.pixabay.com/photo/2018/12/12/20/19/scone-3871598_960_720.jpg', 15, 2, 1),
('Licuados', 150, 'https://cdn.pixabay.com/photo/2020/03/02/15/22/ginger-juice-4896003_1280.jpg', 20, 3, 1),
('Smoothie', 7000, 'https://cdn.pixabay.com/photo/2020/01/09/04/21/smoothie-4751820_1280.jpg', 10, 3, 1),
('Wrap', 7600, 'https://cdn.pixabay.com/photo/2022/08/27/14/12/tawook-chicken-sandwich-7414558_960_720.jpg', 10, 4, 1),
('Ensalada', 3000, 'https://cdn.pixabay.com/photo/2015/05/31/13/59/salad-791891_1280.jpg', 25, 4, 1),
('Pizza', 7000, 'https://cdn.pixabay.com/photo/2016/11/11/00/45/pizza-1815498_960_720.jpg', 18, 4, 1),
('Hamburguesa', 9000, 'https://cdn.pixabay.com/photo/2021/09/20/20/47/hamburger-6641821_960_720.jpg', 12, 4, 1),
('Pastel', 600, 'https://cdn.pixabay.com/photo/2020/03/10/03/49/red-velvet-cake-4917734_1280.jpg', 30, 5, 1),
('Torta Frutos Secos', 600, 'https://cdn.pixabay.com/photo/2016/08/03/05/35/tea-1565932_960_720.jpg', 20, 5, 1),
('Torta de Limon', 600, 'https://cdn.pixabay.com/photo/2017/08/15/14/37/cheesecake-2644161_960_720.jpg', 25, 5, 1),
('Pastel de Chocolate', 600, 'https://cdn.pixabay.com/photo/2015/09/04/11/51/cake-921943_960_720.jpg', 15, 5, 1),
('Macarrones', 3000, 'https://cdn.pixabay.com/photo/2021/03/04/10/14/macaroons-6067490_1280.jpg', 15, 5, 1),
('Panini', 6300, 'https://cdn.pixabay.com/photo/2015/09/11/07/34/food-935393_1280.jpg', 22, 6, 1),
('Tostadas', 5300, 'https://cdn.pixabay.com/photo/2015/07/14/12/56/blackberries-844876_960_720.jpg', 25, 6, 1),
('Sandwich', 4300, 'https://cdn.pixabay.com/photo/2013/10/30/17/08/snack-203135_960_720.jpg', 25, 6, 1),
('Macarrones', 3000, 'https://cdn.pixabay.com/photo/2021/03/04/10/14/macaroons-6067490_1280.jpg', 10, 7, 1),
('Wafles', 7000, 'https://cdn.pixabay.com/photo/2020/05/19/20/54/waffles-5192625_960_720.jpg', 15, 7, 1),
('Cereal con Fruta', 7000, 'https://cdn.pixabay.com/photo/2014/10/13/15/31/muesli-486832_1280.jpg', 12, 7, 1),
('Molino', 50000, 'https://cdn.pixabay.com/photo/2018/06/09/23/27/coffee-3465494_960_720.jpg', 5, 8, 1),
('Cafetera', 35000, 'https://cdn.pixabay.com/photo/2016/12/05/22/23/coffee-1885073_960_720.jpg', 7, 8, 1),
('Tazas', 35000, 'https://cdn.pixabay.com/photo/2014/09/24/17/13/mugs-459324_1280.jpg', 20, 8, 1),
('Tetera', 65000, 'https://cdn.pixabay.com/photo/2017/02/24/10/41/tea-2094420_1280.jpg', 8, 8, 1);

-- Inserción de ventas
INSERT INTO venta (fecha, metodo_pago, total, negocio_id) VALUES 
('2025-05-03 10:00:00', 'Efectivo', 120.00, 1),  -- Venta en Cafetería Coffee Store
('2025-05-03 11:00:00', 'Tarjeta', 400.00, 2);  -- Venta en Ferretería Buloneando

-- Inserción de detalles de venta
INSERT INTO detalle_venta (venta_id, producto_id, cantidad, subtotal) VALUES 
(1, 1, 2, 100.00),  -- Venta de 2 Café Americano en la venta 1 (Cafetería Coffee Store)
(1, 3, 1, 30.00),  -- Venta de 1 Taza de Té en la venta 1 (Cafetería Coffee Store)
(2, 4, 1, 150.00), -- Venta de 1 Martillo en la venta 2 (Ferretería Buloneando)
(2, 5, 1, 250.00); -- Venta de 1 Taladro en la venta 2 (Ferretería Buloneando)

-- Inserción de cierre diario
INSERT INTO cierre_diario (fecha, total, negocio_id) VALUES 
('2025-05-03', 120.00, 1),  -- Cierre diario para Cafetería Coffee Store
('2025-05-03', 400.00, 2);  -- Cierre diario para Ferretería Buloneando

-- ******************************************Ferreteria Buloneando******************************
-- Inserción de categorías
INSERT INTO categoria (nombre, imagen) VALUES 
('Herramientas', 'herramientas.jpg'),
('Materiales de Construcción', 'materiales.jpg'),
('Pinturas y Adhesivos', 'pinturas.jpg');

-- Inserción de productos asociados a 'Ferretería Buloneando'
INSERT INTO producto (nombre, precio, imagen, stock, categoria_id, negocio_id) VALUES 
('Martillo', 150.00, 'martillo.jpg', 100, 1, 1),  -- Categoría 'Herramientas'
('Taladro', 250.00, 'taladro.jpg', 50, 1, 1),     -- Categoría 'Herramientas'
('Sierra', 350.00, 'sierra.jpg', 30, 1, 1),       -- Categoría 'Herramientas'
('Cemento', 100.00, 'cemento.jpg', 200, 2, 1),    -- Categoría 'Materiales de Construcción'
('Ladrillos', 80.00, 'ladrillos.jpg', 500, 2, 1), -- Categoría 'Materiales de Construcción'
('Pintura Acrílica', 120.00, 'pintura.jpg', 80, 3, 1);  -- Categoría 'Pinturas y Adhesivos'

-- Inserción de ventas para 'Ferretería Buloneando'
INSERT INTO venta (fecha, metodo_pago, total, negocio_id) VALUES 
('2025-05-03 10:00:00', 'Efectivo', 500.00, 1),  -- Venta en Ferretería Buloneando
('2025-05-03 11:00:00', 'Tarjeta', 850.00, 1);  -- Venta en Ferretería Buloneando

-- Inserción de detalles de ventas para las ventas realizadas en 'Ferretería Buloneando'
INSERT INTO detalle_venta (venta_id, producto_id, cantidad, subtotal) VALUES 
(1, 1, 2, 300.00),  -- 2 Martillos en la venta 1
(1, 2, 1, 250.00),  -- 1 Taladro en la venta 1
(2, 3, 1, 350.00),  -- 1 Sierra en la venta 2
(2, 4, 3, 300.00);  -- 3 Cementos en la venta 2

-- Inserción de cierre diario para 'Ferretería Buloneando'
INSERT INTO cierre_diario (fecha, total, negocio_id) VALUES 
('2025-05-03', 1350.00, 1);  -- Cierre diario para Ferretería Buloneando
