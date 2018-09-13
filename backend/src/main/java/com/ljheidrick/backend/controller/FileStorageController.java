package com.ljheidrick.backend.controller;

import com.ljheidrick.backend.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class FileStorageController {

    @Autowired
    FileStorageService service;

    @PostMapping("/upload/{fileName}")
    public void saveImage(@RequestParam(value = "file") MultipartFile image,
                          @PathVariable("fileName") String imgName, @RequestParam(value = "folderName") String folderName) throws IOException {
        service.saveFile(image, imgName);
    }

    @DeleteMapping("/{name}")
    public void deleteById(@PathVariable("fileName") String fileName) throws Exception {
        service.deleteFile(fileName);
    }

}