USE sofa;

CREATE TABLE SYS_DRM(
    ID              INT          primary key auto_increment COMMENT  '主键',
    DRM_CODE        VARCHAR(64)  COMMENT  'DRM编码',
    DRM_NAME        VARCHAR(64)  COMMENT '开关名称',
    DRM_STATUS      VARCHAR(64)  COMMENT 'DRM 开关状态'
);
