package com.issueflow.model;

public class Issue {
    private final long id;
    private String title;
    private String description;
    private Priority priority;
    private IssueStatus status;

    public Issue(long id, String title, String description, Priority priority, IssueStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public void changePriority(Priority priority) {
        this.priority = priority;
    }
}
