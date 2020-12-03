--菜单表
create table if not exists menu  (
    id int NOT NULL  comment '菜单id',
    parentId int not null comment '子菜单id',
    title VARCHAR(100) NOT NULL comment '菜单名称',
    `rank` int comment '排序',
    iconUrl VARCHAR(100) comment '图标url',
    url VARCHAR(100) NOT NULL comment '菜单url',
    createDate date comment '创建时间',
    updateDate date comment '更新时间',
    primary key(id)
)
insert into menu values(1,0,'权限管理',1,'iconurl','/authority',now(),null);
insert into menu values(2,0,'系统管理',1,'iconurl-1','/system',now(),null);