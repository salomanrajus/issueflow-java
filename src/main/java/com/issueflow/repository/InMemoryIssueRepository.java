package com.issueflow.repository;

import com.issueflow.model.Issue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryIssueRepository implements IssueRepository {

    private final List<Issue> issues = new ArrayList<>();

    @Override
    public void save(Issue issue) {
        if(issue == null) {
            throw new NullPointerException("Issue cannot be null");
        }

        if(findById(issue.getId()).isPresent()) {
            throw new IllegalArgumentException("Issue already exists");
        }

        issues.add(issue);
    }

    @Override
    public Optional<Issue> findById(long id) {
        return issues.stream()
                .filter(issue -> issue.getId() == id)
                .findFirst();
    }

    @Override
    public List<Issue> findAll() {
        return new ArrayList<>(issues);
    }
}
