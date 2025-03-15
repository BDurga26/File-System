package com.example.File.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.File.system.entity.FileEntity;

public interface XmlFileRepository extends JpaRepository<FileEntity,Long>{

}
