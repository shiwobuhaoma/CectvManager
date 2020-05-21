package com.cec.tv.model;

import java.sql.Date;
import java.sql.Time;

public class Video {
    private long id;
    /**
     * 文件名称
     */
    private String videoName;
    /**
     * 第一帧画面
     */
    private String videoFirstImage;
    private String screenWidth;
    private String screenHeight;
    /**
     * 视频文件大小
     */
    private double videoSize;
    /**
     * 时长
     */
    private Time duration;
    /**
     * 帧率
     */
    private double frameRate;
    /**
     * 上传时间
     */
    private Date updateDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoFirstImage() {
        return videoFirstImage;
    }

    public void setVideoFirstImage(String videoFirstImage) {
        this.videoFirstImage = videoFirstImage;
    }

    public String getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(String screenWidth) {
        this.screenWidth = screenWidth;
    }

    public String getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(String screenHeight) {
        this.screenHeight = screenHeight;
    }

    public double getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(double videoSize) {
        this.videoSize = videoSize;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public double getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(double frameRate) {
        this.frameRate = frameRate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
