create database sofa character set utf8;

CREATE TABLE SYS_USER(
    ID  INT  primary key auto_increment COMMENT  '主键',
    USER_ID     VARCHAR(64)  COMMENT '用户唯一标识',
    USER_ACCOUNT VARCHAR(64)  COMMENT '用户账号' ,
    USER_PASSWORD  varchar(64)  COMMENT '用户密码'
);


)


