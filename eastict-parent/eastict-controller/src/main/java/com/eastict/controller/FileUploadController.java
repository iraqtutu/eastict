package com.eastict.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.eastict.common.utils.JsonUtils;
import com.eastict.service.FileUploadService;


@Controller
public class FileUploadController {

	@Autowired
	private FileUploadService uploadService;
	
	@RequestMapping("/file/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile) {
		Map result = uploadService.uploadFile(uploadFile);
		//为了保证功能的兼容性，需要把Result转换成json格式的字符串。
		String json = JsonUtils.objectToJson(result);
		return json;
	}
}
