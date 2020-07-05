package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("类别实体")
@TableName("category_name")
public class CategoryName {
    @ApiModelProperty(value="id",allowEmptyValue = true,hidden=true)
    private Integer id;
    @ApiModelProperty(value="类别名称",required = true)
    private String name;
    @ApiModelProperty(value="类别列表中的排列位置",required = true)
    private Integer position;
    @ApiModelProperty(value="使用传1，不使用传0",required = true)
    private Integer used;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }
}