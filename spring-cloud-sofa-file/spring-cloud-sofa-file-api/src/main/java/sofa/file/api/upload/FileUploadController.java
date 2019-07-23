package sofa.file.api.upload;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sofa.api.drm.DrmOpenService;
import sofa.common.bean.dto.BaseDTO;
import sofa.common.bean.dto.BaseSuccessDTO;
import sofa.common.bean.model.FileStorageTypeEnum;
import sofa.file.common.service.FileService;
import sofa.file.local.storage.FileLocalStorageService;

import java.io.*;

@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private DrmOpenService drmService;

    /**
     * 本地存储开关
     */
    private static final String FILE_LOCAL_STORAGE_SERVICE = "FILE_LOCAL_STORAGE_SERVICE";


    @PostMapping("/upload.do")
    public BaseDTO upload(@RequestParam String fileName, MultipartFile file) throws IOException {
        BaseSuccessDTO baseDTO = new BaseSuccessDTO<String>();
        //从drm开关处获取选择何种存储方式
        FileService fileService = getFileService();
       //获取文件类型
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());
        //获取文件大小
        long size = file.getSize();
        //获取文件二进制文件
        byte[] bytes = file.getBytes();
        //保存文件成功
        String fileCode = fileService.saveFile(bytes, fileName, size, fileType, FileStorageTypeEnum.LOCAL_STORAGE_TYPE);
        baseDTO.setData(fileCode);
        return baseDTO;
    }

    private FileService getFileService() {
        if (drmService.getDrmStatus(FILE_LOCAL_STORAGE_SERVICE)) {
            return beanFactory.getBean(FileLocalStorageService.class);
        }
        return beanFactory.getBean(FileLocalStorageService.class);
    }


}
