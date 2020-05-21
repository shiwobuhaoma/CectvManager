package com.cec.tv.dao;

import com.cec.tv.model.ImagePath;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImagePathMapper {
    int deleteByPrimaryKey(String id);

    int insert(ImagePath record);

    int insertSelective(ImagePath record);

    ImagePath selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ImagePath record);

    int updateByPrimaryKey(ImagePath record);
}