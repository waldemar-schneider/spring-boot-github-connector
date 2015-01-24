package de.flaviait.spring.social.github.web;

import de.flaviait.spring.social.github.domain.Issue;
import de.flaviait.spring.social.github.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class IssueController {
    
    @Autowired
    private IssueService issueService;
    
    @RequestMapping("{organisation}/{repository}/issues")
    public String issues(Model model, @PathVariable String organisation, @PathVariable String repository) {
        List<Issue> issues = issueService.findIssues(organisation, repository);
        model.addAttribute("issues", issues);
        return "issues/issues";
    }
}
