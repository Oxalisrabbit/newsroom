package com.example.newsroom.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.font.Script;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping(value = "/file")

public class FileController {
    public static final String artpath = "./file/文章";

    /**
     * 下载文件
     * @param filename
     * @param format
     * @param request
     * @param response
     */
    @GetMapping(value = "/download/filename={filename}&format={format}")
    public void downloadFileAction(@PathVariable(value = "filename")String filename, @PathVariable(value = "format")String format, HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");
        FileInputStream fis = null;
        try {
            File file = new File(artpath + filename + "." + format);
            if(!file.exists()){
                response.setStatus(404);
            }else {
                fis = new FileInputStream(file);
                response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
                System.out.print("aaa");
                IOUtils.copy(fis, response.getOutputStream());
                response.flushBuffer();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
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
