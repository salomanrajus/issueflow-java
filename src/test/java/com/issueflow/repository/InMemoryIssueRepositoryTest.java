package com.issueflow.repository;

import com.issueflow.model.Issue;
import com.issueflow.model.IssueStatus;
import com.issueflow.model.Priority;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryIssueRepositoryTest {

    @Test
    void shouldSaveAndFindIssueById() {

        InMemoryIssueRepository repository = new InMemoryIssueRepository();

        Issue issue = new Issue(
                101,
                "Production deployment failed",
                "Application failed during startup",
                Priority.CRITICAL,
                IssueStatus.OPEN
        );

        repository.save(issue);
        var result = repository.findById(101);

        assertTrue(result.isPresent());
        assertEquals("Production deployment failed", result.get().getTitle());
    }
}

