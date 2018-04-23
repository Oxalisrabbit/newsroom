package com.example.newsroom.service;

import com.example.newsroom.entity.Article;
import com.example.newsroom.entity.Invoice;
import com.example.newsroom.entity.Task;

import java.util.*;

public interface ContributeService {
    Integer uploadArticleInfo(Article article);
    Integer updateTask(int id,String content,int stat,int flag);
    Integer createTask(Task task);
    List<Task> getTask(int id_role, int role);
    String getTableByRole(int role);
    List<Map<String,Object>> getAllByTable(String table);
    Integer getRoleIdByTask(int id_article,int role);
    Integer getCountByArticleId(int id_article);
    Article getArticleById(int id);
    Integer createInvoice(Invoice invoice);
}
