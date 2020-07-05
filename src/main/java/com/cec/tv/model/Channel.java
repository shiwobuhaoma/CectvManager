package com.cec.tv.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("频道实体")
@TableName("channel")
public class Channel {
    @ApiModelProperty(value = "id", allowEmptyValue = true, hidden = true)
    @TableId(value = "id", type = IdType.AUTO)//指定自增策略
    private Long id;

    @ApiModelProperty(value = "频道号", required = true)
    @TableField("channelNumber")
    private String channelnumber;

    @ApiModelProperty(value = "创建时间", required = true)
    @TableField("createDate")
    private Date createdate;

    @ApiModelProperty(value = "是否删除传false", required = true)
    @TableField("isDel")
    private Boolean isdel;

    @ApiModelProperty(value = "频道名称", required = true)
    private String name;

    @TableField("playlistName")
    private String playlistname;

    private String remark;
    @ApiModelProperty(value = "频道状态", hidden = true)
    private String state;

    @ApiModelProperty(value = "播流地址", hidden = true)
    @TableField("streamMediaPath")
    private String streammediapath;

    @TableField("playlist_id")
    private Long playlistId;

    @ApiModelProperty(value = "创建人id", hidden = true)
    @TableField("creater_id")
    private Long createrId;

    @ApiModelProperty(value = "台标文件名", hidden = true)
    @TableField("logoFileName")
    private String logofilename;

    @ApiModelProperty(value = "台标文件路径", hidden = true)
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelnumber() {
        return channelnumber;
    }

    public void setChannelnumber(String channelnumber) {
        this.channelnumber = channelnumber;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Boolean getIsdel() {
        return isdel;
    }

    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaylistname() {
        return playlistname;
    }

    public void setPlaylistname(String playlistname) {
        this.playlistname = playlistname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreammediapath() {
        return streammediapath;
    }

    public void setStreammediapath(String streammediapath) {
        this.streammediapath = streammediapath;
    }

    public Long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Long playlistId) {
        this.playlistId = playlistId;
    }

    public Long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    public String getLogofilename() {
        return logofilename;
    }

    public void setLogofilename(String logofilename) {
        this.logofilename = logofilename;
    }

    public String getLogoimgpath() {
        return logoimgpath;
    }

    public void setLogoimgpath(String logoimgpath) {
        this.logoimgpath = logoimgpath;
    }

    public String getPublishwinid() {
        return publishwinid;
    }

    public void setPublishwinid(String publishwinid) {
        this.publishwinid = publishwinid;
    }

    public String getPublishwinnum() {
        return publishwinnum;
    }

    public void setPublishwinnum(String publishwinnum) {
        this.publishwinnum = publishwinnum;
    }

    public String getIconpath() {
        return iconpath;
    }

    public void setIconpath(String iconpath) {
        this.iconpath = iconpath;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getNoticepath() {
        return noticepath;
    }

    public void setNoticepath(String noticepath) {
        this.noticepath = noticepath;
    }
}