---数据初始化脚本

---创建数据库
create database seckill;

---使用数据库
use seckill;

create table seckill(
`seckill_id` bigint not null auto_increment comment '商品id',
`name` varchar(120) not null comment '商品名称',
`number` int not null comment '库存数量',
`start_time` timestamp not null DEFAULT '0000-00-00 00:00:00' comment '秒杀开始时间',
`end_time` timestamp not null DEFAULT '0000-00-00 00:00:00'  comment '秒杀结束时间',
`create_time` timestamp         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀创建时间' ,
 primary key (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)engine= Innodb auto_increment=1000 default charset = utf8 comment="秒杀库存表";


--初始化数据
insert into
	seckill(name,number,start_time,end_time)
	values
	("1000元秒杀iphone6",100,'2018-09-01 00:00:00','2018-10-02 00:00:00'),
	("100元秒杀鸡蛋",100,'2018-09-01 00:00:00','2018-10-02 00:00:00'),
	("20元秒杀苹果",100,'2018-09-01 00:00:00','2018-10-02 00:00:00'),
	("400元秒杀手环",100,'2018-09-01 00:00:00','2018-10-02 00:00:00'),
	("1000元秒杀pad",100,'2018-09-01 00:00:00','2018-10-02 00:00:00');




create table success_kill(
`seckill_id` bigint not null  comment '商品id',
`user_phone` bigint not null comment '商品名称',
`state` tinyint not null default -1 comment '状态 -1无效， 0成功 1-已经付款',
`create_time` timestamp not null default current_timestamp comment '秒杀开始时间',
primary key(seckill_id,user_phone),
key idx_create_time(create_time)
)engine= innodb  default charset = utf8 comment="秒杀库存表";


CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL,
  `user_account` char(20) DEFAULT NULL,
  `user_pwd` char(32) DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_account` (`user_account`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;











