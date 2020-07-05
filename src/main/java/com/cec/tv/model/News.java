package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel("新闻实体")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getHaveImg() {
        return haveImg;
    }

    public void setHaveImg(Integer haveImg) {
        this.haveImg = haveImg;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getNewCategory() {
        return newCategory;
    }

    public void setNewCategory(Integer newCategory) {
        this.newCategory = newCategory;
    }
}