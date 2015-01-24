package de.flaviait.spring.social.github.service;

import de.flaviait.spring.social.github.domain.Issue;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.github.api.GitHubIssue;
import org.springframework.social.github.api.impl.GitHubTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService implements InitializingBean {

    @Value("${github.token}")
    private String githubToken;

    private GitHubTemplate gitHubTemplate;

    @Override
    public void afterPropertiesSet() throws Exception {
        gitHubTemplate = new GitHubTemplate(githubToken);
    }

    public List<Issue> findIssues(String organisation, String repository) {
        List<Issue> issues = new LinkedList<>();

        List<GitHubIssue> gitHubIssues = gitHubTemplate.repoOperations().getIssues(organisation, repository);

        List<Issue> open = gitHubIssues.parallelStream()
                .filter(repo -> repo.getState().equals("open"))
                .map(repo -> new Issue(repository, repo))
                .collect(Collectors.toList());
        issues.addAll(open);

        return issues;
    }
}
