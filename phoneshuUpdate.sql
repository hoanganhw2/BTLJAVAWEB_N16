CREATE TABLE `tbluser` (
  `user_id` int PRIMARY KEY AUTO_INCREMENT,
  `user_name` varchar(255) UNIQUE NOT NULL,
  `user_pass` varchar(255) NOT NULL,
  `user_image` varchar(255),
  `user_fullname` varchar(255),
  `user_gender` bit,
  `user_email` varchar(255),
  `user_phone` varchar(255),
  `user_address` varchar(255),
  `user_role` int,
  `user_createAt` date,
  `user_updateAt` date
);

CREATE TABLE `tblrole` (
  `role_id` int PRIMARY KEY AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  `role_description` varchar(255),
  `role_createAt` date,
  `role_updateAt` date
);

CREATE TABLE `tblcategory` (
  `category_id` int PRIMARY KEY AUTO_INCREMENT,
  `category_name` varchar(255),
  `category_image` varchar(255),
  `category_createAt` date,
  `category_updateAt` date
);

CREATE TABLE `tblproduct` (
  `product_id` int PRIMARY KEY AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `product_image` varchar(255) NOT NULL,
  `product_shortdesc` varchar(255),
  `product_description` varchar(255),
  `product_price` float,
  `product_discount` float,
  `product_quantity` smallint,
  `product_target` varchar(255),
  `product_category` int,
  `product_creatAt` date,
  `product_updateAt` date
);

CREATE TABLE `tblcart` (
  `cart_id` int PRIMARY KEY AUTO_INCREMENT,
  `cart_userid` int,
  `cart_sum` smallint,
  `cart_creatAt` date,
  `cart_updateAt` date
);

CREATE TABLE `tblcartitem` (
  `cartitem_id` int PRIMARY KEY AUTO_INCREMENT,
  `cartitem_cartid` int,
  `cartitem_productid` int,
  `cartitem_quantity` smallint,
  `cartitem_creatAt` date,
  `cartitem_updateAt` date
);

CREATE TABLE `tblorder` (
  `order_id` int PRIMARY KEY,
  `order_userid` int,
  `order_price` float,
  `order_satuts` varchar(255),
  `order_delivery` varchar(255),
  `order_creatAt` date,
  `order_updateAt` date
);

CREATE TABLE `tbleorderitem` (
  `orderitem_id` int PRIMARY KEY AUTO_INCREMENT,
  `orderitem_orderid` int,
  `orderitem_productid` int,
  `orderitem_price` float,
  `orderitem_quantity` smallint,
  `orderitem_creatAt` date,
  `orderitem_updateAt` date
);

CREATE TABLE `tblproductreview` (
  `productreview_id` int PRIMARY KEY AUTO_INCREMENT,
  `productreview_userid` int,
  `productreview_productid` int,
  `productreview_status` bit,
  `productreview_content` varchar(255),
  `productreview_ratingscore` tinyint,
  `productreview_createAt` date,
  `productreview_updateAt` date
);

CREATE TABLE `tblwishlistitem` (
  `wishlistitem_id` int PRIMARY KEY AUTO_INCREMENT,
  `wishlistitem_userid` int,
  `wishlistitem_productid` int,
  `wishlistitem_createAt` datetime,
  `wishlistitem_updateAt` datetime
);

ALTER TABLE `tbluser` ADD FOREIGN KEY (`user_role`) REFERENCES `tblrole` (`role_id`);

ALTER TABLE `tblproduct` ADD FOREIGN KEY (`product_category`) REFERENCES `tblcategory` (`category_id`);

ALTER TABLE `tblcart` ADD FOREIGN KEY (`cart_userid`) REFERENCES `tbluser` (`user_id`);

ALTER TABLE `tblcartitem` ADD FOREIGN KEY (`cartitem_cartid`) REFERENCES `tblcart` (`cart_id`);

ALTER TABLE `tblcartitem` ADD FOREIGN KEY (`cartitem_productid`) REFERENCES `tblproduct` (`product_id`);

ALTER TABLE `tblorder` ADD FOREIGN KEY (`order_userid`) REFERENCES `tbluser` (`user_id`);

ALTER TABLE `tbleorderitem` ADD FOREIGN KEY (`orderitem_orderid`) REFERENCES `tblorder` (`order_id`);

ALTER TABLE `tbleorderitem` ADD FOREIGN KEY (`orderitem_productid`) REFERENCES `tblproduct` (`product_id`);

ALTER TABLE `tblproductreview` ADD FOREIGN KEY (`productreview_userid`) REFERENCES `tbluser` (`user_id`);

ALTER TABLE `tblproductreview` ADD FOREIGN KEY (`productreview_productid`) REFERENCES `tblproduct` (`product_id`);

ALTER TABLE `tblwishlistitem` ADD FOREIGN KEY (`wishlistitem_userid`) REFERENCES `tbluser` (`user_id`);

ALTER TABLE `tblwishlistitem` ADD FOREIGN KEY (`wishlistitem_productid`) REFERENCES `tblproduct` (`product_id`);
