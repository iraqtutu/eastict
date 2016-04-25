package eastict.service.utils;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	Map<String,Object> uploadFile(MultipartFile uploadFile);
}
