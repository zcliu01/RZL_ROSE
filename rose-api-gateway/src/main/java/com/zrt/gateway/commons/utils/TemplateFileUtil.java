package com.zrt.gateway.commons.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.ResourceUtils;

/**
 * Created by 钟述林 393156105@qq.com on 2016/10/28 23:57.
 */
public class TemplateFileUtil {

    public static FileInputStream getTemplates(String tempName) throws FileNotFoundException {
        return new FileInputStream(ResourceUtils.getFile("classpath:excel-templates/"+tempName));
    }
    
    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(new Date());
    }
}