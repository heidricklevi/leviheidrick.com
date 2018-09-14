package com.ljheidrick.backend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {
    String saveFile(MultipartFile multipartFile, String fileName, String folderName) throws IOException;

    void deleteFile(String fileName) throws Exception;
}
