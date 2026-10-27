package com.issueflow.repository;

import com.issueflow.model.Issue;

import java.util.List;
import java.util.Optional;

public interface IssueRepository {

    void save(Issue issue);

    Optional<Issue> findById(long id);

    List<Issue> findAll();
}
