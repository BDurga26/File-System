package com.example.File.system.service;
import com.example.File.system.exception.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.File.system.entity.FileEntity;
import com.example.File.system.exception.FileNotFoundException;
import com.example.File.system.repository.XmlFileRepository;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private XmlFileRepository fileRepository;

    // Method to handle file upload
    public FileEntity saveFile(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setFileType(file.getContentType());
        fileEntity.setData(file.getBytes());

        return fileRepository.save(fileEntity);
    }

    // Method to retrieve file by ID
    public FileEntity getFileById(Long id) {
        return fileRepository.findById(id).orElseThrow(() -> new FileNotFoundException("File with ID " + id + " not found"));
    }
}
