package com.example.newsroom.service.impl;

import com.example.newsroom.dao.ContributeMapper;
import com.example.newsroom.entity.Article;
import com.example.newsroom.entity.Invoice;
import com.example.newsroom.entity.Task;
import com.example.newsroom.service.ContributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ContributeServiceimpl implements ContributeService{
    @Autowired
    ContributeMapper contributeMapper;

    @Override
    public Integer uploadArticleInfo(Article article){
        try{
            return contributeMapper.uploadArticleInfo(article);
        }
        catch (Exception e){
            return null;
        }

    }

    @Override
    public Integer updateTask(int id,String content,int stat,int flag){
        try{
            return contributeMapper.updateTask(id,content,stat,flag);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public Integer createTask(Task task){
        try{
            return contributeMapper.createTask(task);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Task> getTask(int id_role, int role){
        try{
            return contributeMapper.getTask(id_role,role);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public String getTableByRole(int role){
        try{
            return contributeMapper.getTableByRole(role);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Map<String,Object>> getAllByTable(String table){
        try{
            return contributeMapper.getAllByTable(table);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public Integer getRoleIdByTask(int id_article,int role){
        try{
            return contributeMapper.getRoleIdByTask(id_article,role);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public Integer getCountByArticleId(int id_article){
        try{
            return contributeMapper.getCountByArticleId(id_article);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public Article getArticleById(int id){
        try{
            return contributeMapper.getArticleById(id);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public Integer createInvoice(Invoice invoice){
        try{
            return contributeMapper.createInvoice(invoice);
        }
        catch (Exception e){
            return null;
        }
    }
}
