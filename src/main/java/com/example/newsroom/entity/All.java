package com.example.newsroom.entity;

public class All {
    private Article article;
    private Author author;
    private Editor_ editor_;
    private Invoice invoice;
    private Professor professor;
    private Professor_ professor_;
    private Resource resource;
    private Task task;
    private int role;
    private int[] id_role;

    public void setArticle(Article article) {
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setEditor_(Editor_ editor_) {
        this.editor_ = editor_;
    }

    public Editor_ getEditor_() {
        return editor_;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor_(Professor_ professor_) {
        this.professor_ = professor_;
    }

    public Professor_ getProfessor_() {
        return professor_;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Resource getResource() {
        return resource;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setId_role(int[] id_role) {
        this.id_role = id_role;
    }

    public int[] getId_role() {
        return id_role;
    }
}
