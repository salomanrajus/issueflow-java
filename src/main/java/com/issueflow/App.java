package com.issueflow;

import com.issueflow.model.Issue;
import com.issueflow.model.IssueStatus;
import com.issueflow.model.Priority;
import com.issueflow.repository.InMemoryIssueRepository;
import com.issueflow.repository.IssueRepository;

public class App {
    public static void main(String[] args) {

        IssueRepository repo = createRepo();

        repo.findById(999)
                .ifPresentOrElse(
                        issue -> System.out.println("Found: " + issue.getTitle()),
                        () -> System.out.println("Issue not found")
                );

        System.out.println("All Issues: ");
        repo.findAll().forEach(issue ->
                System.out.println(issue.getId() + " | "
                        + issue.getTitle() + " | "
                        + issue.getPriority() + " | "
                        + issue.getStatus()
                )
        );
    }

    private static IssueRepository createRepo() {
        IssueRepository repo = new InMemoryIssueRepository();

        Issue issue1 = new Issue(
                101,
                "Production deployment failed",
                "Application failed during startup",
                Priority.CRITICAL,
                IssueStatus.OPEN
        );

        Issue issue2 = new Issue(
                102,
                "Payment API unavailable",
                "Payment API is not responding",
                Priority.HIGH,
                IssueStatus.IN_PROGRESS
        );

        repo.save(issue1);
        repo.save(issue2);

        try {
            repo.save(null);
            repo.save(issue2);
        }catch (IllegalArgumentException e) {
            System.out.println("Could not save Issue: " + e.getMessage());
        }catch (NullPointerException e) {
            System.out.println("Could not save Issue: " + e.getMessage());
        }

        return repo;
    }
}
