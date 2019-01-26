package com.ljheidrick.backend.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.ljheidrick.backend.model.Files;
import com.ljheidrick.backend.model.Projects;
import com.ljheidrick.backend.repository.FilesRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private String S3_BUCKET_NAME = "com-leviheidrick";

    @Value("${digitalOceanProperties.endpointWithBucketName}")
    private String endpointUrlWithBucketName;

    @Autowired
    AmazonS3 s3Client;

    @Autowired
    FilesRepository filesRepository;

    @Override
    public String saveFile(MultipartFile multipartFile, String imgName, String folderName) throws IOException {
        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        String key = folderName + "/" + imgName + "." + extension;
        File fileToUpload = convertFromMultiPartToFile(multipartFile);
        s3Client.putObject(new PutObjectRequest(S3_BUCKET_NAME, key, fileToUpload)
                .withCannedAcl(CannedAccessControlList.PublicRead));


        return endpointUrlWithBucketName + "/" + key;
    }

    @Override
    public Projects saveFiles(MultipartFile[] multipartFiles, String folderName, Projects projects) throws IOException {
        List<Files> imageUrls = new ArrayList<>();
        Optional<List<Files>> existingFiles = projects.getFiles();

        for (MultipartFile multipartFile : multipartFiles) {
            String url = this.saveFile(multipartFile, multipartFile.getOriginalFilename().split("\\.")[0], folderName);
            Files files = new Files(url, false);
            filesRepository.save(files);

            imageUrls.add(files);
        }

        if (existingFiles.isPresent()) {
            imageUrls.addAll(existingFiles.get());
        }

        projects.setFiles(imageUrls);
        return projects;
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