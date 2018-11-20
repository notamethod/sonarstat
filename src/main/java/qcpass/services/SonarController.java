package qcpass.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qcpass.sonarapi.IssuesService;

@RestController
public class SonarController {


    @Autowired
    private IssuesService issuesService;
    @RequestMapping(value = "/sonar", method = RequestMethod.GET)
    public void getSonarInfos(@RequestParam(value="name", defaultValue="World") String name) {

        //issuesService.hello();
        try {
            issuesService.getIssuesForModule2("org.dpr.apps:mykeys");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

