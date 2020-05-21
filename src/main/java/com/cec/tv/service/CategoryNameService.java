package com.cec.tv.service;

import com.cec.tv.model.CategoryName;

import java.util.List;

public interface CategoryNameService {
    List<CategoryName> getCategoryNames();

    int addCategory(CategoryName categoryName);

    int deleteCategory(CategoryName categoryName);
}
