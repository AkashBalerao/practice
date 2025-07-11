package controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadAndDownloadController {

	
	@RequestMapping("/fileuploadform")
	public String form() {
		return "fileupload";
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file")MultipartFile file , Model model) throws Exception{
		if(!file.isEmpty()) {
			File newFile = new File("D:\\sts\\springMVCandORM\\src\\main\\webapp\\WEB-INF\\downloads" , file.getOriginalFilename());
			file.transferTo(newFile);
			System.out.println(newFile.getAbsolutePath());
			model.addAttribute("msg", "success");
			model.addAttribute("path", newFile.getAbsolutePath());
		}
		else {
			model.addAttribute("msg", "fail");
		}
		return "result";
	}
}
