package sofa.file.common.service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import sofa.common.bean.model.FileStorageTypeEnum;
import sofa.common.bean.dal.FileDO;
import sofa.file.common.dal.FileMapper;
import java.io.IOException;
import java.util.UUID;

public abstract class FileService {

    @Autowired
    private FileMapper fileMapper;


    public String saveFile(byte[] b, String fileName, Long fileSize, String fileType, FileStorageTypeEnum fileStorageType) throws IOException {
        FileDO fileDO = new FileDO();
        String fileCode = UUID.randomUUID().toString();
        //文件编码
        fileDO.setFileCode(fileCode);
        //文件大小
        fileDO.setFileSize(fileSize);
        //文件名称
        fileDO.setFileName(fileName);
        //文件类型
        fileDO.setFileType(fileType);
        //文件存储类型
        fileDO.setFileStorageType(fileStorageType.getFileStorageType());
        fileMapper.insert(fileDO);
        storage(b, fileCode, fileType);
        return fileCode;
    }


    public byte[] download(String fileCode) {
        QueryWrapper<FileDO> queryWrapper = new QueryWrapper();
        queryWrapper.eq("FILE_CODE", fileCode);
        FileDO fileDO = fileMapper.selectOne(queryWrapper);
        return downloadFile(fileCode);
    }


    public abstract byte[] downloadFile(String fileCode);


    public abstract void storage(byte[] bytes, String fileCode, String fileType) throws IOException;


}
