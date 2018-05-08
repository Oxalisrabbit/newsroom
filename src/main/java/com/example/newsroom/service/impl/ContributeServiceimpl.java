package com.example.newsroom.service.impl;

import com.example.newsroom.dao.ContributeMapper;
import com.example.newsroom.entity.Article;
import com.example.newsroom.entity.Invoice;
import com.example.newsroom.entity.Task;
import com.example.newsroom.service.ContributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ContributeServiceimpl implements ContributeService{
    @Autowired
    ContributeMapper contributeMapper;

    @Override
    public Integer updateArticleInfo(int id,String format,Date date_pub){
        try{
            return contributeMapper.updateArticleInfo(id,format,date_pub);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Integer uploadArticleInfo(Article article){
        try{
            return contributeMapper.uploadArticleInfo(article);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public Integer updateTask(int id,int id_role,String content,int stat,int role,int flag,Date date){
        try{
            return contributeMapper.updateTask(id,id_role,content,stat,role,flag,date);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Integer createTask(Task task){
        try{
            return contributeMapper.createTask(task);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Task> getTask(int id_article,int id_role, int role,int stat,int flag,int page){
        try{
            return contributeMapper.getTask(id_article,id_role,role,stat,flag,(page - 1) * 10);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Task getTaskById(int id){
        try{
            return contributeMapper.getTaskById(id);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String getTableByRole(int role){
        try{
            return contributeMapper.getTableByRole(role);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Map<String,Object>> getAllByTable(String table){
        try{
            return contributeMapper.getAllByTable(table);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Integer> getRoleIdByTask(int id_article,int role){
        try{
            return contributeMapper.getRoleIdByTask(id_article,role);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Integer getCountByArticleId(int id_article){
        try{
            return contributeMapper.getCountByArticleId(id_article);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Article getArticleById(int id){
        try{
            return contributeMapper.getArticleById(id);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Integer updateInvoice(int id,int flag,String format,String receipt_title,String receipt_num,String address,String receiver){
        try{
            return contributeMapper.updateInvoice(id,flag,format,receipt_title,receipt_num,address,receiver);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Integer createInvoice(Invoice invoice){
        try{
            return contributeMapper.createInvoice(invoice);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Invoice> getInvoiceByArticleId(int id_article){
        try{
            return contributeMapper.getInvoiceByArticleId(id_article);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String getContentByRoleId(int id_role){
        try{
            return contributeMapper.getContentByRoleId(id_role);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String getStandard(int year){
        try{
            return contributeMapper.getStandard(year);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Integer getCountByDatePub(Date begin,Date end){
        try{
           return contributeMapper.getCountByDatePub(begin,end);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
