package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@ApiModel("频道实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("channel")
public class Channel {
    @ApiModelProperty(value="id",allowEmptyValue = true,hidden=true)
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Long id;

    @ApiModelProperty(value="频道号",required = true)
    @TableField("channelNumber")
    private String channelnumber;

    @ApiModelProperty(value="创建时间",required = true)
    @TableField("createDate")
    private Date createdate;

    @ApiModelProperty(value="是否删除传false",required = true)
    @TableField("isDel")
    private Boolean isdel;

    @ApiModelProperty(value="频道名称",required = true)
    private String name;

    @TableField("playlistName")
    private String playlistname;

    private String remark;
    @ApiModelProperty(value="频道状态",hidden = true)
    private String state;

    @ApiModelProperty(value="播流地址",hidden = true)
    @TableField("streamMediaPath")
    private String streammediapath;

    @TableField("playlist_id")
    private Long playlistId;

    @ApiModelProperty(value="创建人id",hidden = true)
    @TableField("creater_id")
    private Long createrId;

    @ApiModelProperty(value="台标文件名",hidden = true)
    @TableField("logoFileName")
    private String logofilename;

    @ApiModelProperty(value="台标文件路径",hidden = true)
    @TableField("logoImgPath")
    private String logoimgpath;

    @ApiModelProperty(hidden = true)
    @TableField("publishWinId")

    private String publishwinid;
    @ApiModelProperty(hidden = true)
    @TableField("publishWinNum")

    private String publishwinnum;
    @ApiModelProperty(hidden = true)
    @TableField("iconPath")
    private String iconpath;

    @ApiModelProperty(hidden = true)
    private String notice;

    @ApiModelProperty(hidden = true)
    @TableField("noticePath")
    private String noticepath;

}