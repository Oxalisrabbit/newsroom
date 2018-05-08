package com.example.newsroom.dao;

import com.example.newsroom.entity.Article;
import com.example.newsroom.entity.Invoice;
import com.example.newsroom.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ContributeMapper {
    Integer updateArticleInfo(@Param(value = "id") int id,@Param(value = "format") String format,@Param(value = "date_pub") Date date_pub);
    Integer uploadArticleInfo(Article article);
    Integer updateTask(@Param(value = "id") int id,@Param(value = "id_role") int id_role,@Param(value = "content") String content,@Param(value = "stat") int stat,@Param(value = "role") int role,@Param(value = "flag") int flag,@Param(value = "date") Date date);
    Integer createTask(Task task);
    List<Task> getTask(@Param(value = "id_article") int id_article,@Param(value = "id_role") int id_role,@Param(value = "role") int role,@Param(value = "stat") int stat,@Param(value = "flag") int flag,@Param(value = "page") int page);
    Task getTaskById(@Param(value = "id") int id);
    String getTableByRole(@Param(value = "role") int role);
    List<Map<String,Object>> getAllByTable(@Param(value = "table") String table);
    List<Integer> getRoleIdByTask(@Param(value = "id_article") int id_article,@Param(value = "role") int role);
    Integer getCountByArticleId(@Param(value = "id_article") int id_article);
    Article getArticleById(@Param(value = "id") int id);
    Integer updateInvoice(@Param(value = "id") int id,@Param(value = "flag") int flag,@Param(value = "format") String format,@Param(value = "receipt_title") String receipt_title,@Param(value = "receipt_num") String receipt_num,@Param(value = "address") String address,@Param(value = "receiver") String receiver);
    Integer createInvoice(Invoice invoice);
    List<Invoice> getInvoiceByArticleId(@Param(value = "id_article") int id_article);
    String getContentByRoleId(@Param(value = "id_role") int id_role);
    String getStandard(@Param(value = "year") int year);
    Integer getCountByDatePub(@Param(value = "begin") Date begin,@Param(value = "end") Date end);
}
