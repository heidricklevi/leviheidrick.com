package com.ljheidrick.backend.service;

import com.ljheidrick.backend.model.Projects;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {
    String saveFile(MultipartFile multipartFile, String fileName, String folderName) throws IOException;
    Projects saveFiles(MultipartFile[] multipartFiles, String folderName, Projects projects) throws IOException;


    void deleteFile(String fileName) throws Exception;
}
