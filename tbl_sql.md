### DDL


CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(50) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `order_status` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) NOT NULL,
  `unit_price` int(11) NOT NULL,
  `product_species` varchar(50) NOT NULL,
  `temp_opt` varchar(40) DEFAULT NULL,
  `size_opt` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `product_opt` (
  `product_opt_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_opt_temp` enum('HOT','ICE','NONE') DEFAULT NULL,
  `product_opt_size` enum('SHORT','TALL','GRANDE','VENTI','NONE') DEFAULT NULL,
  PRIMARY KEY (`product_opt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


 CREATE TABLE shop (
   shop_name varchar(100) NOT NULL,
   shop_address varchar(100) NOT NULL,
   shop_phone varchar(100) NOT NULL,
   CONSTRAINT shop_pk PRIMARY KEY (shop_name)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;


CREATE TABLE `order_details` (
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_opt_id` int(11) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `order_details_fk` (`product_id`),
  KEY `order_details_fk_2` (`product_opt_id`),
  CONSTRAINT `order_details_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `order_details_fk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `order_details_fk_2` FOREIGN KEY (`product_opt_id`) REFERENCES `product_opt` (`product_opt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

---

### DML >>> INSERT

INSERT INTO ezenbucks.customer (customer_name) VALUES
('김용국')
,('이창호')
,('이지찬')
,('황혜진');

INSERT INTO ezenbucks.product (product_name,unit_price,product_species,temp_opt,size_opt) VALUES
('아메리카노',2000,'drink','hot,ice','short,tall,grande,venti')
,('카푸치노',2000,'drink','hot,ice','short,tall,grande,venti')
,('카페라뗴',2000,'drink','hot,ice','short,tall,grande,venti')
,('카푸치노',2000,'drink','hot,ice','short,tall,grande,venti')
,('허니버터브래드',2000,'food',NULL,NULL)
,('딸기케이크',2000,'food',NULL,NULL)
,('초코케이크',2000,'food',NULL,NULL);

INSERT INTO ezenbucks.product_opt (product_opt_temp,product_opt_size) VALUES
('HOT','SHORT')
,('HOT','TALL')
,('HOT','GRANDE')
,('HOT','VENTI')
,('ICE','SHORT')
,('ICE','TALL')
,('ICE','GRANDE')
,('ICE','VENTI')
,('NONE','NONE');

INSERT INTO ezenbucks.shop (shop_name,shop_address,shop_phone) VALUES
('스타벅스 강남교보타워R점','서울 서초구 서초동 1303-22','1522-3232')
,('스타벅스 강남에비뉴점','서울 서초구 서초동 1303-16','1522-3232')
,('스타벅스 몬테소리점','서울 서초구 서초동 1318-8','1522-3232')
,('스타벅스 봉은사역점','서울 강남구 삼성동 108-6','1522-3232')
,('스타벅스 삼성도심공항점','서울 강남구 삼성동 154-10','1522-3232')
,('스타벅스 코엑스사거리점','서울 강남구 삼성동 91-34','1522-3232');








