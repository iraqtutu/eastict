package com.eastict.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	Map uploadFile(MultipartFile uploadFile);
}
