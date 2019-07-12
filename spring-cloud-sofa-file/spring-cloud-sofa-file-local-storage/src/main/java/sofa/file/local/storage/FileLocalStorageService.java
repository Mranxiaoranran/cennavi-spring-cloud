package sofa.file.local.storage;

import ch.qos.logback.core.util.DatePatternToRegexUtil;
import org.joda.time.DateTimeUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import sofa.file.common.service.FileService;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileLocalStorageService extends FileService {
    /**
     * 文件基础目录
     */
    private static final String FILE_DIR = "/sofa";


    @Override
    public void storage(byte[] bytes, String fileCode, String fileType) throws IOException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);
        String fileDirStr = new StringBuffer().append(FILE_DIR).append("/").append(dateStr).toString();
        String fileStr = new StringBuffer().append(fileDirStr).append("/").append(fileCode).append(fileType).toString();
        File fileDir = new File(fileDirStr);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        File file = new File(fileStr);
        file.createNewFile();
        FileCopyUtils.copy(bytes, file);
    }
}
