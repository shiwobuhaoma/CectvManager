package com.cec.tv.dao;

import com.cec.tv.model.CategoryName;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryNameMapper {
    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(CategoryName record);

    int insertSelective(CategoryName record);

    CategoryName selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryName record);

    int updateByPrimaryKey(CategoryName record);

    List<CategoryName> getCategoryNames();
}