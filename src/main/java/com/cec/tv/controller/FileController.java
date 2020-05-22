package com.cec.tv.controller;

import com.cec.tv.result.ResponseMessage;
import com.cec.tv.service.ImagePathService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;


@Api(tags = "上传图片或者视频相关接口")
@RequestMapping(value = "/file/")
@RestController
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    ImagePathService mImagePathService;

    @ApiOperation(value = "单文件上传接口",httpMethod="POST")
    @ResponseBody
    @RequestMapping(value = "upload")
    public ResponseMessage<String> upload(
            @ApiParam(name="type",value="上传图片的类型【（imgpath：1寸照片，fullfacephotopath：正面照，sidefacephotopath：侧面照，fullbodyphotopath：全身照，videointroduction：视频介绍）】",required=true)@RequestParam String type ,
            @ApiParam(name="id",value="身份证号",required=true) @RequestParam String id ,
            @ApiParam(name="file",value="文件",required=true) @RequestParam("file") MultipartFile file) {
        ResponseMessage<String> result = new ResponseMessage<>();
        // 设置文件存储路径
        StringBuilder filePath = new StringBuilder("/picture");
        try {
            if (file.isEmpty()) {
                return result.setFailure("文件为空");
            }

            //一寸照片
            if ("imgpath".equals(type)){
                if (biggerThanOneM(file)) return result.setFailure("照片大于1M");
                filePath.append("/imgpath");
            }
            //如果是正面照
            if ("fullfacephotopath".equals(type)){
                if (biggerThanOneM(file)) return result.setFailure("照片大于1M");
                filePath.append("/fullfacephotopath");
            }
            //如果是侧面照
            if ("sidefacephotopath".equals(type)){
                if (biggerThanOneM(file)) return result.setFailure("照片大于1M");
                filePath.append("/sidefacephotopath");
            }
            //如果是全身照
            if ("fullbodyphotopath".equals(type)){
                if (biggerThanOneM(file)) return result.setFailure("照片大于1M");
                filePath.append("/fullbodyphotopath");
            }
            //如果是个人介绍视频
            if ("videointroduction".equals(type)){
                if (file.getSize()>1024*1024*100) return result.setSuccess("视频文件大于100M");
                filePath.append("/videointroduction");
            }


            // 获取文件名
            String fileName = file.getOriginalFilename();
            log.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("文件的后缀名为：" + suffixName);
            File dirFile = new File(filePath.toString());
            if (!dirFile.exists()){
                dirFile.mkdirs();
            }
            String path = filePath.append(fileName).toString();
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            int i = mImagePathService.insertPath(filePath.toString(),id,type);
            if (i>0){
                return result.setSuccess("上传成功");
            }else{
                return result.setFailure("数据库写入文件路径失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
        return result.setFailure("上传失败");
    }

    private boolean biggerThanOneM(@RequestParam("file") MultipartFile file) {
        if (isBigThanOneM(file)){
            return true;
        }
        return false;
    }

    @ApiOperation(value = "批量文件上传接口",httpMethod="POST")
    @ResponseBody
    @RequestMapping("batch")
    public ResponseMessage<String> handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        ResponseMessage<String> result = new ResponseMessage<>();
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            String filePath = "/picture/";
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(filePath + file.getOriginalFilename())));//设置文件路径及名字
                    stream.write(bytes);// 写入
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return result.setFailure( "第 " + i + " 个文件上传失败 ==> "
                            + e.getMessage());
                }
            } else {
                return result.setFailure("第 " + i
                        + " 个文件上传失败因为文件为空");
            }
        }
        return result.setSuccess("上传成功");
    }

    @ApiOperation(value = "文件下载接口",httpMethod="GET")
    @ResponseBody
    @RequestMapping("download")
    public ResponseMessage<String> downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "dalaoyang.jpeg";// 文件名
        ResponseMessage<String> result = new ResponseMessage<>();
        if (fileName != null) {
            //设置文件路径
            File file = new File("/Users/dalaoyang/Documents/dalaoyang.jpeg");
            //File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return result.setSuccess("下载成功");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return result.setFailure("下载失败");
    }


    private boolean isBigThanOneM(MultipartFile file){
        if (file.getSize() > 1024*1024){
            return true;
        }else{
            return false;
        }
    }
}
