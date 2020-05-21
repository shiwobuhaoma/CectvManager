package com.cec.tv.controller;


import com.cec.tv.model.CategoryName;
import com.cec.tv.result.ResponseMessage;
import com.cec.tv.result.ResultEnum;
import com.cec.tv.service.CategoryNameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(tags = "新闻分类相关接口", description = "提供新闻分类相关的API")
@RestController
@RequestMapping("/category/")
public class CategoryNameController {


    @Autowired
    CategoryNameService category;

    @ApiOperation(value = "获取分类列表接口",httpMethod="POST")
    @RequestMapping("getCategoryNames")
    @ResponseBody
    public List<CategoryName> getCategoryNames() {
        return category.getCategoryNames();
    }

    @ApiOperation(value = "增加分类接口",httpMethod="POST")
    @Transactional
    @ResponseBody
//    @RequiresRoles(value = {"admin"})
//    @RequiresPermissions("admin:all")
    @RequestMapping("addCategory")
    public ResponseMessage<String> addCategory(@RequestBody CategoryName categoryName) {
        int i = category.addCategory(categoryName);
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        if (i != 0) {
            responseMessage.setResultEnum(ResultEnum.ADD_CATEGORY_SUCCESS);
        }else{
            responseMessage.setResultEnum(ResultEnum.ADD_CATEGORY_FAILURE);
        }

        return responseMessage;
    }

    @ApiOperation(value = "删除分类接口",httpMethod="POST")
    @Transactional
    @ResponseBody
//    @RequiresRoles(value = {"admin"})
//    @RequiresPermissions("admin:all")
    @RequestMapping("deleteCategory")
    public ResponseMessage<String> deleteCategory(@RequestBody CategoryName categoryName) {
        int i = category.deleteCategory(categoryName);
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        if (i != 0) {
            responseMessage.setResultEnum(ResultEnum.DELETE_CATEGORY_SUCCESS);
        }else{
            responseMessage.setResultEnum(ResultEnum.DELETE_CATEGORY_FAILURE);
        }

        return responseMessage;
    }
}
