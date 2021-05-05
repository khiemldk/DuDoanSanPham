-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 06, 2021 at 01:49 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `DuDoanSanPham1`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `cate_id` int(11) NOT NULL,
  `name` varchar(500) NOT NULL,
  `code` varchar(50) NOT NULL,
  `price` float NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `des` varchar(5000) DEFAULT NULL,
  `number_access` int(11) NOT NULL,
  `sold` int(11) DEFAULT NULL,
  `active_flag` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `cate_id`, `name`, `code`, `price`, `image`, `des`, `number_access`, `sold`, `active_flag`) VALUES
(1, 25, 'Thắt lưng da', 'Byrle', 598, 'A75.jpeg', 'non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus', 6478, 6640, 1),
(2, 16, 'Bàn gỗ tự nhiên', 'Reamonn', 996, 'A44.jpg', 'vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum', 504, 7391, 1),
(3, 10, 'Giày Nữ Trắng', 'Quillan', 388, 'A27.jpg', 'dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat', 9836, 1306, 1),
(4, 17, 'Kem PS', 'Kaine', 238, 'A47.jpg', 'bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce', 8859, 1422, 1),
(5, 7, 'Xe Honda SH', 'Conn', 560, 'A16.jpg', 'fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis', 9619, 7452, 1),
(6, 4, 'Lenovo Mới', 'Cedric', 434, 'A9.png', 'parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur', 9956, 600, 1),
(7, 8, 'Áo Sơ Mi Kaki', 'Desmond', 504, 'A21.jpg', 'nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede', 3589, 5910, 1),
(8, 13, 'Ghế gấp xanh', 'Zared', 571, 'A36.jpg', 'amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum', 1005, 7717, 1),
(9, 27, 'Ví nữ', 'Aldus', 594, 'A86.jpg', 'volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc', 3897, 7559, 1),
(10, 24, 'Kính chỗng UV', 'Dorian', 513, 'A70.jpg', 'lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi', 7646, 8067, 1),
(11, 18, 'Quạt điện cơ', 'Roderich', 476, 'A51.jpg', 'pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id', 6728, 9157, 1),
(12, 26, 'Sữa Không đường', 'Oates', 859, 'A83.jpg', 'tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque', 2223, 1560, 1),
(13, 7, 'Xe WayAlpha', 'Adam', 680, 'A17.jpg', 'eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus', 7667, 5689, 1),
(14, 6, 'Tai nghe Rapoo', 'Hurleigh', 56, 'A14.jpg', 'turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor', 2991, 5303, 1),
(15, 7, 'Xe AirBlade', 'Vincents', 513, 'A18.jpg', 'mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere', 7077, 9506, 1),
(16, 22, 'Dưa hấu', 'Early', 611, 'A61.jpg', 'lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum', 8384, 4455, 1),
(17, 4, 'Macbook 2015', 'Willey', 167, 'A10.jpg', 'lorem ipsum dolor sit amet consectetuer adipiscing elit proin risus praesent', 935, 3523, 1),
(18, 10, 'Giày Adidas Rùnalcon', 'Say', 786, 'A28.jpg', 'id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo', 3080, 6136, 1),
(19, 14, 'Xe TOTEM ANGLE', 'Shaine', 14, 'A40.png', 'sit amet eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor', 8035, 2207, 1),
(20, 1, 'Kem chống nắng', 'Darb', 137, 'A1.png', 'amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien in', 4390, 1054, 1),
(21, 22, 'Cam', 'Yank', 340, 'A62.jpg', 'fusce consequat nulla nisl nunc nisl duis bibendum felis sed', 5767, 3783, 1),
(22, 25, 'Thắt lưng A89', 'Griff', 68, 'A76.jpg', 'quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id', 1033, 3097, 1),
(23, 21, 'Cocacola', 'Neddie', 437, 'A57.jpg', 'et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc', 6439, 3113, 1),
(24, 23, 'Đồng hồ kim', 'Lamar', 6, 'A67.jpeg', 'pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis', 8845, 5451, 1),
(25, 3, 'Điện thoại Vivo', 'Gaspar', 195, 'A4.jpg', 'elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum', 8235, 5025, 1),
(26, 13, 'Ghế chân quỳ', 'Garey', 7, 'A37.jpg', 'venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet', 6858, 8076, 1),
(27, 3, 'Iphone 12 XS', 'Terrance', 119, 'A5.jpeg', 'lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat', 3864, 9390, 1),
(28, 24, 'Kính râm', 'Craggie', 937, 'A71.jpg', 'euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin', 5236, 4945, 1),
(29, 11, 'Dép quai ngang', 'Hillery', 876, 'A33.jpg', 'malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor', 3264, 8247, 1),
(30, 3, 'Redmi Pro Max', 'Jae', 724, 'A3.jpg', 'augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia', 7191, 6306, 1),
(31, 28, 'Dầu gội lifeboy', 'Hugh', 659, 'A89.jpg', 'iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit', 4955, 2159, 1),
(32, 25, 'Thắt lưng đen', 'Durante', 397, 'A77.jpg', 'nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio', 4945, 2616, 1),
(33, 12, 'Bút bi thiên long', 'Hugh', 919, 'A34.jpg', 'purus sit amet nulla quisque arcu libero rutrum ac lobortis vel dapibus at diam nam tristique tortor', 5608, 3084, 1),
(34, 29, 'Dove', 'Jerrie', 668, 'A90.jpeg', 'justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales scelerisque mauris sit', 3918, 5618, 1),
(35, 19, 'Chupachup', 'Tore', 516, 'A54.jpeg', 'integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in', 9619, 5056, 1),
(36, 20, 'Nước 7up', 'Gran', 227, 'A56.jpg', 'nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper', 8764, 2859, 1),
(37, 24, 'Kính Nobita', 'Lee', 974, 'A72.jpg', 'at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc', 7010, 1306, 1),
(38, 8, 'Áo Sơ Mi Thun', 'Mac', 959, 'A22.jpg', 'eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed', 6748, 9562, 1),
(39, 26, 'Sữa tiệt trùng', 'Brandy', 987, 'A84.jpg', 'magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien', 439, 9690, 1),
(40, 29, 'Dầu gội thái dương', 'Giffie', 987, 'A91.jpeg', 'sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis', 4434, 2974, 1),
(41, 10, 'Giày MLB BosTon', 'Pennie', 241, 'A29.png', 'quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna', 5192, 2038, 1),
(42, 10, 'Giày trẻ trung nam', 'Chuck', 60, 'A30.jpeg', 'varius ut blandit non interdum in ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae', 4442, 4272, 1),
(43, 3, 'Vinsmart', 'Ty', 678, 'A6.jpeg', 'mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non', 8468, 6322, 1),
(44, 9, 'Quần Âu Mĩ', 'Raymund', 98, 'A23.jpeg', 'pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus', 2442, 5601, 1),
(45, 15, 'Thước kẻ', 'Donall', 807, 'A42.jpg', 'turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris', 9307, 4556, 1),
(46, 13, 'Ghế xoay lưới', 'Kenneth', 878, 'a38.jpg', 'in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie', 8468, 3198, 1),
(47, 18, 'Quạt Lửng', 'Horton', 343, 'A52.jpg', 'quis odio consequat varius integer ac leo pellentesque ultrices mattis odio', 5341, 7196, 1),
(48, 15, 'Thước kẻ dẻo', 'Ewell', 816, 'A43.jpg', 'iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut', 7746, 7068, 1),
(49, 29, 'Dầu gội Pamolive', 'Irvin', 695, 'A92.jpg', 'arcu libero rutrum ac lobortis vel dapibus at diam nam', 8337, 9683, 1),
(50, 17, 'PS Bạc Hà', 'Dev', 834, 'A48.jpg', 'in faucibus orci luctus et ultrices posuere cubilia curae donec', 2072, 3090, 1),
(51, 3, 'Redmi 8', 'Nickola', 419, 'A7.jpg', 'magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus', 2698, 5963, 1),
(52, 9, 'Bộ Đồ Adidas', 'Paquito', 302, 'A24.jpg', 'a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut', 5464, 533, 1),
(53, 30, 'Bàn Phím cơ', 'Guss', 91, 'A94.png', 'non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non', 7168, 616, 1),
(54, 30, 'Bàn phím latitu', 'Ade', 46, 'A95.jpg', 'sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis', 6802, 4666, 1),
(55, 21, 'String', 'Kasper', 395, 'A58.jpeg', 'nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas', 7162, 5386, 1),
(56, 17, 'Colgate', 'Carmine', 132, 'A49.jpg', 'ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra', 5429, 2731, 1),
(57, 29, 'Berthe', 'Ario', 258, 'A93.jpeg', 'ac nulla sed vel enim sit amet nunc viverra dapibus', 9828, 202, 1),
(58, 23, 'Đồng hồ thông minh', 'Farleigh', 259, 'A68.jpg', 'pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices', 614, 1227, 1),
(59, 9, 'Quần Adidas 3 Sọc', 'Sloan', 499, 'A25.jpg', 'sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor', 8406, 4574, 1),
(60, 4, 'Thinkpad X99', 'Hurley', 668, 'A11.jpg', 'ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio', 715, 995, 1),
(61, 22, 'Táo tàu', 'Forbes', 231, 'A63.jpg', 'mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere', 8514, 3786, 1),
(62, 22, 'Bơ xanh', 'Lyon', 200, 'A64.jpg', 'nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi', 9699, 5249, 1),
(63, 24, 'Kính cận 2 độ', 'Tomkin', 255, 'A73.jpg', 'aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in', 3667, 318, 1),
(64, 25, 'Thắt lưng da bò', 'Jud', 295, 'A78.jpg', 'euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc', 6145, 1821, 1),
(65, 4, 'Dell Express 9950', 'Ugo', 204, 'A12.jpg', 'lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus', 9229, 9771, 1),
(66, 14, 'Xe thống nhất', 'Hank', 38, 'A41.jpg', 'dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non', 5488, 1738, 1),
(67, 5, 'Surface', 'Loydie', 670, 'A13.jpg', 'eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis', 6555, 8971, 1),
(68, 25, 'Thắt Lưng LV\r\n', 'Horace', 785, 'A79.jpg', 'orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur', 2607, 8292, 1),
(69, 1, 'Kem Nghệ', 'Olav', 611, 'A2.jpg', 'amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi', 4907, 7738, 1),
(70, 13, 'Ghế phòng ăn', 'Vidovik', 940, 'A39.jpg', 'turpis eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis', 6534, 2466, 1),
(71, 17, 'SENSODYNE', 'Warden', 194, 'A50.jpg', 'massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in', 2899, 3759, 1),
(72, 12, 'Bút bi cao cấp', 'Clayson', 635, 'A35.jpg', 'dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris', 5161, 4754, 1),
(73, 19, 'Kẹo trái tim', 'Pren', 69, 'A55.png', 'posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat', 829, 2609, 1),
(74, 30, 'Bàn phím có dây', 'Cesar', 763, 'A96.jpg', 'eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget', 7000, 8714, 1),
(75, 30, 'Bàn phí chơi game', 'Andrea', 690, 'A97.png', 'congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus', 1139, 8564, 1),
(76, 26, 'Sữa cho bé', 'Arther', 799, 'A85.jpg', 'pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id', 1030, 564, 1),
(77, 21, 'Pepsi', 'Gus', 163, 'A59.jpg', 'dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit', 7548, 7278, 1),
(78, 9, 'Quần bò', 'Levey', 243, 'A26.jpg', 'cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien', 2627, 1378, 1),
(79, 21, 'Nước Sprice', 'Ulises', 671, 'A60.jpg', 'hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum', 4802, 6863, 1),
(80, 7, 'Kawazaki', 'Isidoro', 777, 'A19.jpg', 'vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur', 3527, 7032, 1),
(81, 10, 'Giày Nữ BL26', 'Wallie', 842, 'A31.jpg', 'tristique in tempus sit amet sem fusce consequat nulla nisl nunc', 1673, 2180, 1),
(82, 3, 'Nokia window', 'Marlo', 356, 'A8.jpg', 'pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras', 2012, 4560, 1),
(83, 21, 'Anabel', 'Clayborn', 639, 'A61.jpeg', 'eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero', 3803, 6572, 1),
(84, 25, 'Thắt Lưng MV02', 'Rupert', 440, 'A80.jpg', 'vestibulum velit id pretium iaculis diam erat fermentum justo nec', 3856, 318, 1),
(85, 16, 'Bàn đặc biệt', 'Corbet', 188, 'A45.jpg', 'pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer', 4634, 513, 1),
(86, 10, 'Giày vans', 'Kendrick', 904, 'A32.jpeg', 'justo eu massa donec dapibus duis at velit eu est congue elementum in', 5283, 5628, 1),
(87, 7, 'Exciter 175cc', 'Errol', 91, 'A20.png', 'est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus', 6911, 8593, 1),
(88, 24, 'Kính club', 'Haskell', 995, 'A74.jpeg', 'lectus in est risus auctor sed tristique in tempus sit amet sem', 5946, 96, 1),
(89, 25, 'Thắt Lưng Ý', 'Jarrett', 869, 'A81.jpg', 'nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a', 2300, 8600, 1),
(90, 22, 'Mít chín', 'Valentin', 823, 'A65.jpg', 'in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor', 3785, 7535, 1),
(91, 30, 'Bàn phím, chuột Logitect', 'Ambrosius', 207, 'A98.jpg', 'ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu', 9089, 6344, 1),
(92, 27, 'Ví da bò', 'Gilles', 763, 'A87.jpg', 'eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna', 6567, 612, 1),
(93, 27, 'Ví từ úc', 'Sayer', 967, 'A88.jpg', 'dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent', 6699, 6634, 1),
(94, 18, 'Quạt Nhiều cánh', 'Bartholomeo', 480, 'A53.jpg', 'eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis', 5372, 1576, 1),
(95, 16, 'Bàn ngồi', 'Leland', 818, 'A46.jpeg', 'blandit non interdum in ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere', 2825, 2180, 1),
(96, 22, 'Xoài chín', 'Aylmar', 462, 'A66.jpg', 'elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus', 5747, 7942, 1),
(97, 25, 'Thắt Lưng Đẹp', 'Archie', 330, 'A82.jpg', 'eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum', 8089, 241, 1),
(98, 6, 'Tai nghe Earpods', 'Seward', 718, 'A15.jpg', 'nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet', 5218, 9517, 1),
(99, 23, 'Đồng Hồ rolex', 'Marlow', 585, 'A69.jpg', 'nulla quisque arcu libero rutrum ac lobortis vel dapibus at', 7231, 5871, 1),
(100, 10, 'Giày Sneaker', 'Vincenty', 232, 'A32.jpg', 'amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus', 5479, 4417, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
