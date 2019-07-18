
CREATE TABLE SYS_FILE(

    ID              INT          primary key auto_increment COMMENT  '主键',

    FILE_CODE       VARCHAR(64)      COMMENT  '文件编码',

    FILE_NAME      VARCHAR(256)      COMMENT   '文件名称',

    FILE_SIZE      INT    COMMENT   '文件大小',

    FILE_TYPE        VARCHAR(64)       COMMENT    '文件存储类型',

    FILE_STORAGE_TYPE   INT             COMMENT    '文件存储类型'
)

CREATE  TABLE SYS_FILE_STORAGE_TYPE(

     ID                       INT              primary key auto_increment COMMENT  '主键',

     FILE_STORAGE_TYPE         INT               COMMENT    '文件存储类型',

     FILE_STORAGE_NAME        VARCHAR(64)        COMMENT     '文件存储类型名称',

     DRIVER_CLASS_NAME       VARCHAR(64)         COMMENT     '文件操作驱动类型'
)

CREATE TABLE   SYS_FILE_LOCAL_STORAGE(

   ID                      INT                primary key auto_increment COMMENT  '主键',

   FILE_CODE              VARCHAR(64)         COMMENT  '文件编码',

   FILE_PATH              VARCHAR(128)        COMMENT  '文件路径',

   FILE_LOCAL_PATH       VARCHAR(256)         COMMENT  '文件存储相对路径'
)

