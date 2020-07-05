package com.cec.tv.utils;

import net.coobird.thumbnailator.Thumbnails;

import java.io.IOException;

public class ThumbnailsUtil {
    /**
     * scale: 按比例
     * outputQuality：输出的图片质量，范围：0.0~1.0，1为最高质量。注意使用该方法时输出的图片格式必须为jpg
     *
     * @throws IOException
     */
    public static void compressPic(String in, String out) throws IOException {

        Thumbnails.of(in)
                .scale(1f)
                //保持长宽比例
                .keepAspectRatio(true)
                .outputQuality(0.25f)
                .toFile(out);
    }
}
