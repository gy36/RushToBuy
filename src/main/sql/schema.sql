---���ݳ�ʼ���ű�

---�������ݿ�
create database seckill;

---ʹ�����ݿ�
use seckill;

create table seckill(
`seckill_id` bigint not null auto_increment comment '��Ʒid',
`name` varchar(120) not null comment '��Ʒ����',
`number` int not null comment '�������',
`start_time` timestamp not null DEFAULT '0000-00-00 00:00:00' comment '��ɱ��ʼʱ��',
`end_time` timestamp not null DEFAULT '0000-00-00 00:00:00'  comment '��ɱ����ʱ��',
`create_time` timestamp         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '��ɱ����ʱ��' ,
 primary key (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)engine= Innodb auto_increment=1000 default charset = utf8 comment="��ɱ����";


--��ʼ������
insert into
	seckill(name,number,start_time,end_time)
	values
	("1000Ԫ��ɱiphone6",100,'2018-09-01 00:00:00','2018-10-02 00:00:00'),
	("100Ԫ��ɱ����",100,'2018-09-01 00:00:00','2018-10-02 00:00:00'),
	("20Ԫ��ɱƻ��",100,'2018-09-01 00:00:00','2018-10-02 00:00:00'),
	("400Ԫ��ɱ�ֻ�",100,'2018-09-01 00:00:00','2018-10-02 00:00:00'),
	("1000Ԫ��ɱpad",100,'2018-09-01 00:00:00','2018-10-02 00:00:00');




create table success_kill(
`seckill_id` bigint not null  comment '��Ʒid',
`user_phone` bigint not null comment '��Ʒ����',
`state` tinyint not null default -1 comment '״̬ -1��Ч�� 0�ɹ� 1-�Ѿ�����',
`create_time` timestamp not null default current_timestamp comment '��ɱ��ʼʱ��',
primary key(seckill_id,user_phone),
key idx_create_time(create_time)
)engine= innodb  default charset = utf8 comment="��ɱ����";


CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL,
  `user_account` char(20) DEFAULT NULL,
  `user_pwd` char(32) DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_account` (`user_account`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;











