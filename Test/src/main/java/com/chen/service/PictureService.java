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
	 * ����ͼƬ
	 */
	@Transactional
	public Map<Object, String> savePicture(MultipartFile file, ModelMap map) throws IOException {

		Map<Object, String> resultMap = new HashMap<>();

		// ����ͼƬ��·����ͼƬ�ϴ��ɹ��󣬽�·�����浽���ݿ�
		String filePath = "F:\\images";
		// ��ȡԭʼͼƬ����չ��
		String originalFilename = file.getOriginalFilename();
		// �����ļ��µ�����
		String newFileName = UUID.randomUUID() + originalFilename;
		// ��װ�ϴ��ļ�λ�õ�ȫ·��
		File targetFile = new File(filePath, newFileName);
		file.transferTo(targetFile);

		Picture picture = new Picture();
		picture.setUrl(newFileName);
		// ���浽���ݿ�
		pictureMapper.insertSelective(picture);

		resultMap.put("status", "200");
		resultMap.put("url", newFileName);
	
		return resultMap;

	}

}
