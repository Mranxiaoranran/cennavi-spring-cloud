package sofa.file.api.upload;

import org.apache.catalina.core.ApplicationPart;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @PostMapping("/upload.do")
    public void upload(@RequestParam String fileName, MultipartFile file) throws IOException {
        File downLoad  =  new File("E://"+fileName);
        downLoad.mkdir();
        FileCopyUtils.copy(file.getBytes(),downLoad);
    }




}
