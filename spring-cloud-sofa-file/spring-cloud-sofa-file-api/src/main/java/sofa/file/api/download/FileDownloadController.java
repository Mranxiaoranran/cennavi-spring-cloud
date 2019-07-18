package sofa.file.api.download;

import org.springframework.web.bind.annotation.*;
import sofa.file.common.service.FileService;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileDownloadController {

    private FileService fileService;

    /**
     * 文件下载
     */
    @GetMapping("/download/${fileCode}")
    public void download(@PathVariable String fileCode, HttpServletResponse response) {

    }


}
