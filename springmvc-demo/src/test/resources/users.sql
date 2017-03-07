DROP TABLE IF EXISTS `users`;  
  
CREATE TABLE `users` (  
  `id` int(11) NOT NULL COMMENT '用户id',
  `username` varchar(40) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `pic` varchar(100) DEFAULT NULL COMMENT '用户图片', 
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;  
  
/*Data for the table `users` */  
  
insert  into `users`(`id`,`username`,`password`,`pic`) values (1,'user_1',md5('password1'),'');