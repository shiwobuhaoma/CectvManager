package com.cec.tv.controller;


import com.cec.tv.model.Students;
import com.cec.tv.result.ResponseMessage;
import com.cec.tv.service.StudentsService;
import com.cec.tv.utils.TextUtils;
import com.cec.tv.utils.ThumbnailsUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Ignore
@Api(tags = "上传图片或者视频相关接口")
@RequestMapping(value = "/file/")
@RestController
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    StudentsService mStudentsService;

    @ApiOperation(value = "单文件上传接口", httpMethod = "POST")
    @ResponseBody
    @RequestMapping(value = "upload")
    public ResponseMessage<String> upload(
            @ApiParam(name = "type", value = "上传图片的类型【（imgpath：1寸照片，" +
                    "fullfacephotopath：正面照，" +
                    "sidefacephotopath：侧面照，" +
                    "fullbodyphotopath：全身照，" +
                    "videointroduction：视频介绍）】", required = true) @RequestParam String type,
            @ApiParam(name = "mobile", value = "手机号", required = true) @RequestParam String mobile,
            @ApiParam(name = "name", value = "报名人的姓名", required = true) @RequestParam String name,
            @ApiParam(name = "file", value = "文件", required = true) @RequestParam("file") MultipartFile file
    ) throws Exception {
        ResponseMessage<String> result = new ResponseMessage<>();
        if (TextUtils.isEmpty(mobile) || TextUtils.isEmpty(name)) {
            return result.setFailure("需要填写手机号和姓名");
        }
        if (file == null) {
            return result.setFailure("需要上传文件");
        } else {
            try {
                // 设置文件存储路径
                StringBuilder filePath = new StringBuilder("/upload");
                filePath.append(File.separator).append(name).append(mobile).append(File.separator);
                File dirFile = new File(filePath.toString());
                if (!dirFile.exists()) {
                    dirFile.mkdirs();
                }
                // 获取文件名
                String fileName = file.getOriginalFilename();
                log.info("上传的文件名为：" + fileName);
                // 获取文件的后缀名
                assert fileName != null;
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                log.info("文件的后缀名为：" + suffixName);
                Students student = new Students();
                student.setMobile(mobile);
                String path = "";
                if ("fullfacephotopath".equals(type)) {
                    path = filePath.append("正面照").append(suffixName).toString();
                    if (big600KB(file)) {
                        ThumbnailsUtil.compressPic(file.getOriginalFilename(), path);
                    }
                    student.setFullfacephotopath(path);
                } else if ("sidefacephotopath".equals(type)) {
                    path = filePath.append("侧面照").append(suffixName).toString();
                    if (big600KB(file)) {
                        ThumbnailsUtil.compressPic(file.getOriginalFilename(), path);
                    }
                    student.setSidefacephotopath(path);
                } else if ("fullbodyphotopath".equals(type)) {
                    path = filePath.append("全身照").append(suffixName).toString();
                    if (big600KB(file)) {
                        ThumbnailsUtil.compressPic(file.getOriginalFilename(), path);
                    }
                    student.setFullbodyphotopath(path);
                } else {
                    path = filePath.append("视频介绍").append(suffixName).toString();
                    if (big6M(file)) {
                        ThumbnailsUtil.compressPic(file.getOriginalFilename(), path);
                    }

                    student.setVideointroduction(path);
                }
                // 文件写入
//                File dest = new File(path);
//                file.transferTo(dest);

                int i1 = mStudentsService.update(student);
                if (i1 > 0) {
                    return result.setSuccess("上传成功");
                } else {
                    return result.setFailure("写入数据库错误");
                }

            } catch (Exception e) {
                e.printStackTrace();
                return result.setFailure(e.getMessage());
            }
        }

    }

    @ApiOperation(value = "批量文件上传接口", httpMethod = "POST")
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
                    return result.setFailure("第 " + i + " 个文件上传失败 ==> "
                            + e.getMessage());
                }
            } else {
                return result.setFailure("第 " + i
                        + " 个文件上传失败因为文件为空");
            }
        }
        return result.setSuccess("上传成功");
    }

    @ApiOperation(value = "批量文件上传接口", httpMethod = "POST")
    @ResponseBody
    @RequestMapping("batch2")
    public ResponseMessage<String> handleFileUpload(
            @ApiParam(name = "fullfacephotopath", value = "正面半身照", required = true) @RequestParam("fullfacephotopath") MultipartFile file1,
            @ApiParam(name = "fullfacephotopath", value = "侧面半身照", required = true) @RequestParam("sidefacephotopath") MultipartFile file2,
            @ApiParam(name = "fullfacephotopath", value = "正面全身照", required = true) @RequestParam("fullbodyphotopath") MultipartFile file3,
            @ApiParam(name = "fullfacephotopath", value = "1分钟视频", required = true) @RequestParam("videointroduction") MultipartFile file4,
            @ApiParam(name = "otherFile", value = "其它文件") @RequestParam("otherFile") MultipartFile file5

    ) {
        ResponseMessage<String> result = new ResponseMessage<>();
        String originalFilename1 = file1.getOriginalFilename();
        try {
            InputStream inputStream1 = file1.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.setSuccess("OK");
    }

    @ApiOperation(value = "文件下载接口", httpMethod = "GET")
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

    private boolean big600KB(MultipartFile file) {
        return file.getSize() >= 6 * 100 * 1024;
    }

    private boolean big6M(MultipartFile file) {
        return file.getSize() >= 6 * 1024 * 1024;
    }
}
