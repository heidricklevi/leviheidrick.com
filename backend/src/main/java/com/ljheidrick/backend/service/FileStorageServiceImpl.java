package com.ljheidrick.backend.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private String S3_BUCKET_NAME = "com-leviheidrick";

    @Value("${digitalOceanProperties.endpointWithBucketName}")
    private String endpointUrlWithBucketName;

    @Autowired
    AmazonS3 s3Client;

    @Override
    public String saveFile(MultipartFile multipartFile, String imgName, String folderName) throws IOException {
        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        System.out.println("Folder Name: " + folderName);
        String key = folderName + "/" + imgName + "." + extension;
        File fileToUpload = convertFromMultiPartToFile(multipartFile);
        s3Client.putObject(new PutObjectRequest(S3_BUCKET_NAME, key, fileToUpload)
                .withCannedAcl(CannedAccessControlList.PublicRead));


        return endpointUrlWithBucketName + "/" + key;
    }

    @Override
    public void deleteFile(String fileName) throws Exception {
        s3Client.deleteObject(new DeleteObjectRequest(S3_BUCKET_NAME, fileName));
    }

    private File convertFromMultiPartToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        return file;
    }

}