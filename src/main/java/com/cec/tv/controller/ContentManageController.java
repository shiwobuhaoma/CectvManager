package com.cec.tv.controller;

import com.cec.tv.model.Video;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ContentManageController {



    @GetMapping("content/getVideoList/{id}")
    public List<Video> getVideoList(@PathVariable String id){
        System.out.println(id);
        return null;
    }
}
