package com.chen.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.chen.bean.Picture;
import com.chen.dao.PictureMapper;

@Service
public class PictureService {

	@Autowired
	private PictureMapper pictureMapper;

	/*
	 * 保存图片
	 */
	@Transactional
	public Map<Object, String> savePicture(MultipartFile file, ModelMap map) throws IOException {

		Map<Object, String> resultMap = new HashMap<>();

		// 保存图片的路径，图片上传成功后，将路径保存到数据库
		String filePath = "F:\\images";
		// 获取原始图片的扩展名
		String originalFilename = file.getOriginalFilename();
		// 生成文件新的名字
		String newFileName = UUID.randomUUID() + originalFilename;
		// 封装上传文件位置的全路径
		File targetFile = new File(filePath, newFileName);
		file.transferTo(targetFile);

		Picture picture = new Picture();
		picture.setUrl(newFileName);
		// 保存到数据库
		pictureMapper.insertSelective(picture);

		resultMap.put("status", "200");
		resultMap.put("url", newFileName);
	
		return resultMap;

	}

}
