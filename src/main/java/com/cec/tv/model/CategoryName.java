package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@ApiModel("类别实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
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


}