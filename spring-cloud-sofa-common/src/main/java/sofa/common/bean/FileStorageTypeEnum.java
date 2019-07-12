package sofa.common.bean;

public enum FileStorageTypeEnum {

    LOCAL_STORAGE_TYPE(1);

    private Integer fileStorageType;


    FileStorageTypeEnum(int type) {
        this.fileStorageType = type;
    }


    public Integer getFileStorageType() {
        return fileStorageType;
    }

    public void setFileStorageType(Integer fileStorageType) {
        this.fileStorageType = fileStorageType;
    }
}
