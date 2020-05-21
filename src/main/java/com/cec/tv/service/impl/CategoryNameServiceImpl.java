package com.cec.tv.service.impl;

import com.cec.tv.dao.CategoryNameMapper;
import com.cec.tv.model.CategoryName;
import com.cec.tv.service.CategoryNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryNameServiceImpl implements CategoryNameService {

    @Autowired
    CategoryNameMapper categoryNameMapper;

    public List<CategoryName> getCategoryNames(){

        return categoryNameMapper.getCategoryNames();
    }

    @Override
    public int addCategory(CategoryName categoryName) {
        return categoryNameMapper.insert(categoryName);
    }

    @Override
    public int deleteCategory(CategoryName categoryName) {
        return categoryNameMapper.updateByPrimaryKey(categoryName);
    }
}
