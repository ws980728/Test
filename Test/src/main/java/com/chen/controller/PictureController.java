package com.chen.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chen.service.PictureService;

@Controller
public class PictureController {

	@Autowired
	private PictureService pictureService;

	@RequestMapping("/save")
	@ResponseBody
	public Map<Object, String> save(MultipartFile file, ModelMap map) {
		Map<Object, String> resultMap = new HashMap<>();

		try {
			resultMap = pictureService.savePicture(file, map);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultMap;
	}

}
