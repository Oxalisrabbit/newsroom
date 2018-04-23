package com.example.newsroom.controller;

import com.example.newsroom.entity.*;
import com.example.newsroom.service.ContributeService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping(value = "/contribute")
public class ContributeController {
    @Autowired
    ContributeService contributeService;

    /**
     *
     * @param all
     * @param request
     * @return
     */
    @PostMapping(value = "/upload")
    public Object uploadFile(@RequestBody All all,HttpServletRequest request){
        Article article = all.getArticle();
        Task task = all.getTask();
        List<MultipartFile> file = ((MultipartHttpServletRequest)request).getFiles("file");
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        for(int i = 0;i < file.size();i++){
            result = upload(file.get(i));
            if(result != 1){
                result = 0;
                i = file.size();
            }
        }
        if(result == 1){
            if(task == null){//第一次投稿
                result = contributeService.uploadArticleInfo(article);
                if(result == 1) {
                    task = new Task();
                    task.setId_article(article.getId());
                    task.setId_role(1);
                    task.setRole(2);
                    task.setStat(0);
                    task.setFlag(0);
                    task.setDate(new Date());
                    result = contributeService.createTask(task);
                    if (result == 1) {
                        data = "";
                    }
                    else{
                        result = 0;
                        data = "Insert Failed";
                    }
                }
                else{
                    result = 0;
                    data = "Upload Failed";
                }
            }
            else{//修改后再投递
                result = contributeService.updateTask(task.getId(),null,0,1);
                if(result == 1){
                    task.setId_role(contributeService.getRoleIdByTask(task.getId_article(),3));
                    task.setContent(null);
                    task.setRole(3);
                    task.setStat(7);
                    task.setFlag(0);
                    task.setDate(new Date());
                    result = contributeService.createTask(task);
                    if(result == 1){
                        data = "";
                    }
                    else{
                        result = 0;
                        data = "Insert Failed";
                    }
                }
                else{
                    result = 0;
                    data = "Update Failed";
                }
            }
        }
        else{
            result = 0;
            data = "Mkdir Failed";
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param all
     * @return
     */
    @PostMapping(value = "/download")
    public Object downloadFile(@RequestBody All all){
        Task task = all.getTask();
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        Object data = null;
        String[] filename = new String[2];
        Article article = contributeService.getArticleById(task.getId_article());
        String[] format = article.getFormat().split(";");
        for(int i = 0;i < format.length;i++){
            filename[i] = "127.0.0.1:8080/upload/" + article.getId() + "-" + article.getTitle() + "." + format[i];
        }
        data = filename;
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param id_role
     * @param role
     * @return
     */
    @PostMapping(value = "/task")
    public Object getTask(@RequestParam(value = "id_role") int id_role,@RequestParam(value = "role") int role){
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        Object data = null;
        List<Task> task = null;
        task = contributeService.getTask(id_role,role);
        if(task != null){
            result = 1;
            data = task;
        }
        else{
            data = "Select Failed";
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param all
     * @return
     */
    @PostMapping(value = "/task/resource")
    public Object getResource(@RequestBody All all){
        Resource resource = all.getResource();
        Map<String,Object> map = new HashMap<>();
        Integer result = 1;
        List<Map<String,Object>> data = null;
        data = contributeService.getAllByTable(resource.getFunc());
        if(all.getResource().getFunc().equals("editors") || all.getResource().getFunc().equals("professors")){
            for(int i = 0;i < data.size();i++){
                data.get(i).remove("password");
                data.get(i).remove("safeque1");
                data.get(i).remove("safeque2");
                data.get(i).remove("safeque3");
            }
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param all
     * @return
     */
    @PostMapping(value = "/task/allocate")
    public Object allocateArticle(@RequestBody All all){
        Task task = all.getTask();
        int id_role = all.getId_role()[0];
        System.out.println(task);
        System.out.println(id_role);
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        result = contributeService.updateTask(task.getId(),null,0,1);
        if(result == 1){
            task.setId_role(id_role);
            task.setRole(3);
            task.setDate(new Date());
            result = contributeService.createTask(task);
            if(result == 1){
                data = "";
            }
            else{
                result = 0;
                data = "Insert Failed";
            }
        }
        else{
            result = 0;
            data = "Update Failed";
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param all
     * @return
     */
    @PostMapping(value = "/task/judge")
    public Object judgeArticle(@RequestBody All all) {
        Task task = all.getTask();
        Map<String, Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        result = contributeService.updateTask(task.getId(), task.getContent(), task.getStat(), 1);
        if (result == 1) {
            if (task.getStat() == 1) {//初审通过
                task.setId_role(contributeService.getArticleById(task.getId_article()).getWriter_id());
                task.setStat(6);
                task.setRole(1);
                contributeService.createTask(task);
            } else if (task.getContent() != null) {//审稿人提交审稿意见
                result = contributeService.getCountByArticleId(task.getId_article());
                if (result % 3 == 0) {
                    task.setId_role(contributeService.getRoleIdByTask(task.getId_article(), task.getRole()));
                    task.setRole(3);
                    task.setContent(null);
                    task.setFlag(0);
                    result = contributeService.createTask(task);
                    if (result == 1) {
                        data = "";
                    } else {
                        result = 0;
                        data = "Insert Failed";
                    }
                }
            }
        } else {
            result = 0;
            data = "Update Failed";
        }
        map.put("result", result);
        map.put("data", data);
        return map;
    }

    /**
     *
     * @param all
     * @return
     */
    @PostMapping(value = "/task/manage")
    public Object manageInvoice(@RequestBody All all){
        Task task = all.getTask();
        Invoice invoice = all.getInvoice();
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        result = contributeService.updateTask(task.getId(),null,0,1);
        if(result == 1){
            data = "";
            invoice.setDate(new Date());
            result = contributeService.createInvoice(invoice);
            if(result == 1){
                data = "";
                task.setId_role(contributeService.getRoleIdByTask(task.getId_article(),1));
                task.setRole(1);
                task.setDate(new Date());
                result = contributeService.createTask(task);
                if(result == 1){
                    data = "";
                }
                else{
                    result = 0;
                    data = "Insert Failed";
                }
            }
            else{
                result = 0;
                data = "Insert Failed";
            }
        }
        else{
            result = 0;
            data = "Update Failed";
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param all
     * @return
     */
    @PostMapping(value = "/task/fill")
    public Object fillInvoice(@RequestBody All all){
        Task task = all.getTask();
        Invoice invoice = all.getInvoice();
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        result = contributeService.updateTask(task.getId(),null,0,1);
        if(result == 1){
            data = "";
            invoice.setDate(new Date());
            result = contributeService.createInvoice(invoice);
            if(result == 1){
                data = "";
                task.setId_role(contributeService.getRoleIdByTask(task.getId_article(),3));
                task.setRole(3);
                task.setDate(new Date());
                result = contributeService.createTask(task);
                if(result == 1){
                    data = "";
                }
                else{
                    result = 0;
                    data = "Insert Failed";
                }
            }
            else{
                result = 0;
                data = "Insert Failed";
            }
        }
        else{
            result = 0;
            data = "Update Failed";
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param all
     * @return
     */
    @PostMapping(value = "/task/check")
    public Object checkInvoice(@RequestBody All all){
        Task task = all.getTask();
        int[] id_role = all.getId_role();
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        if(task.getStat() == 2){
            result = contributeService.updateTask(task.getId(),null,6,0);
            if(result == 1){
                data = "";
            }
            else{
                result = 0;
                data = "Update Failed";
            }
        }
        else{
            result = contributeService.updateTask(task.getId(),null,task.getStat(),1);
            if(result == 1){
                if(task.getStat() == 1){
                    data = "";
                    for(int i = 0;i < id_role.length;i++){
                        task.setId_role(id_role[i]);
                        task.setRole(4);
                        task.setDate(new Date());
                        result = contributeService.createTask(task);
                        if(result != 1){
                            result = 0;
                            data = "Insert failed";
                            i = id_role.length;
                        }
                    }
                }
                else if(task.getStat() == 6){
                    task.setId_role(1);
                    task.setRole(2);
                    task.setDate(new Date());
                    result = contributeService.createTask(task);
                    if(result == 1){
                        data = "";
                    }
                    else{
                        result = 0;
                        data = "Insert Failed";
                    }
                }
            }
            else{
                result = 0;
                data = "Update Failed";
            }
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param all
     * @return
     */
    @PostMapping(value = "/task/analyze")
    public Object analyzeOpinion(@RequestBody All all){
        Task task = all.getTask();
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        result = contributeService.updateTask(task.getId(),task.getContent(),task.getStat(),1);
        if(result == 1){
            if(task.getStat() == 4){
                task.setStat(5);
            }
            else if(task.getStat() == 2 || task.getStat() ==3){
                task.setId_role(contributeService.getArticleById(task.getId_article()).getWriter_id());
                task.setRole(1);
            }
            result = contributeService.createTask(task);
            if(result == 1){
                data = "";
            }
            else{
                result = 0;
                data = "Insert Failed";
            }
        }
        else{
            result = 0;
            data = "Update Failed";
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param all
     * @return
     */
    @PostMapping(value = "/task/design")
    public Object designArticle(@RequestBody All all){
        Task task = all.getTask();
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        result = contributeService.updateTask(task.getId(),null,0,1);
        if(result == 1){
            task.setId_role(contributeService.getArticleById(task.getId_article()).getWriter_id());
            task.setRole(1);
            task.setDate(new Date());
            result = contributeService.createTask(task);
            if(result == 1){
                data = "";
            }
            else{
                result = 0;
                data = "Insert Failed";
            }
        }
        else{
            result = 0;
            data = "Update Failed";
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param all
     * @return
     */
    @PostMapping(value = "/notice")
    public Object noticeAuthor(@RequestBody All all){
        Task task = all.getTask();
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        result = contributeService.updateTask(task.getId(),null,0,1);
        if(result == 1){
            data = "";
            task.setId_role(contributeService.getRoleIdByTask(task.getId_article(),3));
            task.setRole(3);
            task.setDate(new Date());
            result = contributeService.createTask(task);
            if(result == 1){
                data = "";
            }
            else{
                result = 0;
                data = "Insert Failed";
            }
        }
        else{
            result = 0;
            data = "Update Failed";
        }
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param all
     * @return
     */
    @PostMapping(value = "/task/schedule")
    public Object scheduleArticle(@RequestBody All all){
        Task task = all.getTask();
        Map<String,Object> map = new HashMap<>();
        Integer result = 0;
        String data = null;
        map.put("result",result);
        map.put("data",data);
        return map;
    }

    /**
     *
     * @param upload
     * @return
     */
    public Integer upload(MultipartFile upload){
        Integer result = 1;
        String title = upload.getOriginalFilename();
        String filepath = "/upload";
        try {
            File file = new File(filepath);
            if (!file.exists()){
                file.mkdirs();
            }
            FileOutputStream out = new FileOutputStream(filepath + title);
            out.write(upload.getBytes());
            out.flush();
            out.close();
        }
        catch (Exception e){
            result = 0;
        }
        return result;
    }
}
