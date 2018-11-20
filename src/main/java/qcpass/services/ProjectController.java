package qcpass.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qcpass.domain.Project;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProjectController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public Project getProject(@RequestParam(value="name", defaultValue="World") String name) {
        return new Project("ProjGroup1",
                5);
    }
}

