package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("照片及视频地址")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("imagepath")
public class ImagePath {
    private String id;

    private String imgpath;

    private String fullfacephotopath;

    private String sidefacephotopath;

    private String fullbodyphotopath;

    private String videointroduction;


    public ImagePath(String filePath, String id, String type) {
        this.id = id;
        //一寸照片
        if ("imgpath".equals(type)) {
            imgpath = filePath;
        }
        //如果是正面照
        if ("fullfacephotopath".equals(type)) {
            imgpath = filePath;
        }
        //如果是侧面照
        if ("sidefacephotopath".equals(type)) {
            imgpath = filePath;
        }
        //如果是全身照
        if ("fullbodyphotopath".equals(type)) {
            imgpath = filePath;
        }
        //如果是个人介绍视频
        if ("videointroduction".equals(type)) {
            imgpath = filePath;
        }
    }
}