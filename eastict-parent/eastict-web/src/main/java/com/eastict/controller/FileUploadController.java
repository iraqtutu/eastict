package com.eastict.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.eastict.common.utils.JsonUtils;
import com.eastict.service.utils.FileUploadService;


@Controller
public class FileUploadController {

	@Autowired
	private FileUploadService uploadService;
	
	@RequestMapping(value="/file/upload",method = RequestMethod.POST)
	@ResponseBody
	public String fileUpload(@RequestParam(value="file", required=true) MultipartFile uploadFile) {
		Map<String,Object> result = uploadService.uploadFile(uploadFile);
		String json = JsonUtils.objectToJson(result);
		return json;
	}
}
