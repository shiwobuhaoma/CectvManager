package com.cec.tv.service.impl;

import com.cec.tv.dao.ImagePathMapper;
import com.cec.tv.model.ImagePath;
import com.cec.tv.service.ImagePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImagePathServiceImpl implements ImagePathService {
    @Autowired
    ImagePathMapper imagePathMapper;
    @Override
    public int insertPath(String filePath,String id,String type) {
        ImagePath path = new ImagePath(filePath);
        path.setId(id);
        return imagePathMapper.insert(path);
    }
}
