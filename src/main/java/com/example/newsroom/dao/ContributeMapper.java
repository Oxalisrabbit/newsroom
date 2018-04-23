package com.example.newsroom.dao;

import com.example.newsroom.entity.Article;
import com.example.newsroom.entity.Invoice;
import com.example.newsroom.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ContributeMapper {
    Integer uploadArticleInfo(Article article);
    Integer updateTask(@Param(value = "id") int id,@Param(value = "content") String content,@Param(value = "stat") int stat,@Param(value = "flag") int flag);
    Integer createTask(Task task);
    List<Task> getTask(@Param(value = "id_role") int id_role,@Param(value = "role") int role);
    String getTableByRole(int role);
    List<Map<String,Object>> getAllByTable(@Param(value = "table") String table);
    Integer getRoleIdByTask(@Param(value = "id_article") int id_article,@Param(value = "role") int role);
    Integer getCountByArticleId(@Param(value = "id_article") int id_article);
    Article getArticleById(@Param(value = "id") int id);
    Integer createInvoice(@Param(value = "invoice") Invoice invoice);
}
