package com.example.newsroom.service;

import com.example.newsroom.entity.Article;
import com.example.newsroom.entity.Invoice;
import com.example.newsroom.entity.Task;

import java.util.*;

public interface ContributeService {
    Integer updateArticleInfo(int id,String format,Date date_pub);
    Integer uploadArticleInfo(Article article);
    Integer updateTask(int id,int id_role,String content,int stat,int role,int flag,Date date);
    Integer createTask(Task task);
    List<Task> getTask(int id_article,int id_role, int role,int stat,int flag,int page);
    Task getTaskById(int id);
    String getTableByRole(int role);
    List<Map<String,Object>> getAllByTable(String table);
    List<Integer> getRoleIdByTask(int id_article,int role);
    Integer getCountByArticleId(int id_article);
    Article getArticleById(int id);
    Integer updateInvoice(int id,int flag,String format,String receipt_title,String receipt_num,String address,String receiver);
    Integer createInvoice(Invoice invoice);
    List<Invoice> getInvoiceByArticleId(int id_article);
    String getContentByRoleId(int id_role);
    String getStandard(int year);
    Integer getCountByDatePub(Date begin,Date end);
}
