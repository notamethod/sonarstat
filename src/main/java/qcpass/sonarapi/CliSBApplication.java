package qcpass.sonarapi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
public class CliSBApplication {

    private static final Logger log = LoggerFactory.getLogger(SBApplication.class);



    @Autowired
    private ProjectsService projectsService;
    @Autowired
    private IssuesService issuesService;
    public static void main(String args[]) {
        SpringApplication.run(SBApplication.class);
    }


    @Bean
    public CommandLineRunner run(ProjectsService projectsService) throws Exception {


//        projectsService.getProjects();
//        issuesService.hello();
//        issuesService.getIssuesForModule();

        return null;
    }
}