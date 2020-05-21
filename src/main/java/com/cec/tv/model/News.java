package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@ApiModel("新闻实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("news")
public class News {
    @ApiModelProperty(value="id",allowEmptyValue = true,hidden=true)
    private Integer id;

    @ApiModelProperty(value="新闻标题",required = true)
    private String title;
    @ApiModelProperty(value="创建时间",required = true)
    @TableField(value = "create_date")
    private Date createDate;
    @ApiModelProperty(value="由谁创建",required = true)
    @TableField(value = "create_by")
    private String createBy;
    @ApiModelProperty(value="新闻图片位置",required = true)
    @TableField(value = "img_path")
    private String imgPath;
    @ApiModelProperty(value="是否有新闻图片",required = true)
    @TableField(value = "have_img")
    private Integer haveImg;
    @ApiModelProperty(value="评论数",hidden = true)
    @TableField(value = "comment_count")
    private Integer commentCount;
    @ApiModelProperty(value="数据哪类新闻",hidden = true)
    @TableField(value = "new_category")
    private Integer newCategory;


}