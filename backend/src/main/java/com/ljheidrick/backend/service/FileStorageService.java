package com.ljheidrick.backend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {
    void saveFile(MultipartFile multipartFile, String fileName) throws IOException;

    void deleteFile(String fileName) throws Exception;
}
