package com.cec.tv.controller;


import com.cec.tv.model.Channel;
import com.cec.tv.result.ResponseMessage;
import com.cec.tv.service.ChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "频道相关接口", description = "提供频道相关的API")
@RestController
@RequestMapping(value = "/channel/")
public class ChannelController {

    @Autowired
    private ChannelService channelService;
    @ApiOperation(value = "获取频道列表接口",httpMethod="POST")
    @ResponseBody
//    @RequiresPermissions("student:test")
    @RequestMapping(value = "getChannelList",method = {RequestMethod.POST})
    public ResponseMessage<List<Channel>> getChannelList(){
        List<Channel> channelList = channelService.getChannelList();
        ResponseMessage<List<Channel>> responseMessage = new ResponseMessage<List<Channel> > ();
        if (channelList != null && channelList.size()>0){
            responseMessage.setSuccess("获取频道信息成功");
            responseMessage.setData(channelList);
        }else{
            responseMessage.setFailure("获取频道信息失败");
        }
        return responseMessage;

    }
    @ApiOperation(value = "增加频道接口",httpMethod="POST")
    @Transactional
    @ResponseBody
    @RequestMapping(value = "addNewChannel",method = {RequestMethod.POST})
    public ResponseMessage<String> insertNewChannel(@RequestBody Channel channel){
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        if (channel != null) {
            int i = channelService.insertNewChannel(channel);
            if (i > 0){
                responseMessage.setSuccess("创建频道成功");
            }else{
                responseMessage.setSuccess("创建频道失败");
            }
        }else{
            responseMessage.setSuccess("参数有误");
        }
        return responseMessage;
    }
    @ApiOperation(value = "删除频道接口",httpMethod="POST")
    @Transactional
    @ResponseBody
    @RequestMapping(value = "deleteChannel",method = {RequestMethod.POST})
    public ResponseMessage<String> deleteChannel(@RequestParam String channelId){
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        if (channelId != null){
            int i = channelService.deleteChannel(channelId);
            if (i > 0){
                responseMessage.setSuccess("删除频道成功");
            }else{
                responseMessage.setSuccess("删除频道失败");
            }
        }else{
            responseMessage.setSuccess("channelId参数为空");
        }
        return responseMessage;
    }

}
