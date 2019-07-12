package sofa.file.api.upload;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sofa.common.bean.BaseDTO;
import sofa.common.bean.BaseSuccessDTO;
import sofa.common.bean.FileStorageTypeEnum;
import sofa.file.common.service.FileService;
import sofa.file.local.storage.FileLocalStorageService;

import java.io.*;

@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private BeanFactory beanFactory;


    @PostMapping("/upload.do")
    public BaseDTO upload(@RequestParam String fileName, MultipartFile file) throws IOException {
        BaseSuccessDTO baseDTO = new BaseSuccessDTO<String>();
        FileService fileService = beanFactory.getBean(FileLocalStorageService.class);
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());
        long size = file.getSize();
        byte[] bytes = file.getBytes();
        String fileCode = fileService.saveFile(bytes, fileName, size, fileType, FileStorageTypeEnum.LOCAL_STORAGE_TYPE);
        baseDTO.setData(fileCode);
        return baseDTO;
    }


}
