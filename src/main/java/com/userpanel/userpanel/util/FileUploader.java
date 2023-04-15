package com.userpanel.userpanel.util;

import com.userpanel.userpanel.util.exception.FileException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.userpanel.userpanel.constant.AppConstant.SLASH;

@Component
public class FileUploader {

    private final String filesPath;
    private final String host;

    public FileUploader(@Value("${user.panel.files.folder}") String filesPath, @Value("${user.panel.host}") String host) {
        this.filesPath = filesPath;
        this.host = host;
    }

    public String uploadFile(MultipartFile file) {
        try {
            String filePath = String.join(SLASH, host, filesPath, file.getOriginalFilename());
            Path path = Paths.get(String.join(SLASH, filesPath, file.getOriginalFilename()));
            file.transferTo(path);
            return filePath;
        } catch (IOException e) {
            throw new FileException();
        }
    }
}
