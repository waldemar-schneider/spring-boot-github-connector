package de.flaviait.spring.social.github.domain;

import org.springframework.social.github.api.GitHubIssue;

public class Issue {
    
    private String repo;
    
    private GitHubIssue gitHubIssue;

    public Issue(String repo, GitHubIssue gitHubIssue) {
        this.repo = repo;
        this.gitHubIssue = gitHubIssue;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public GitHubIssue getGitHubIssue() {
        return gitHubIssue;
    }

    public void setGitHubIssue(GitHubIssue gitHubIssue) {
        this.gitHubIssue = gitHubIssue;
    }
}
