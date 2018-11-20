package qcpass.sonarapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import qcpass.domain.Project;

import java.util.List;

@org.springframework.stereotype.Component
public class ProjectsService {

    private static final Logger log = LoggerFactory.getLogger(ProjectsService.class);

    private String url = "https://sonarcloud.io/api/components/search?qualifiers=TRK&q=mongo";
    private String url3 = "https://sonarcloud.io/api/issues/search?componentKeys=ss14&resolved=false&types=VULNERABILITY";

    private String url2 = "http://gturnquist-quoters.cfapps.io/api/random";

    private RestTemplate restTemplate;

    @Autowired
    public ProjectsService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

//    public static void main(String args[]) {
//        SpringApplication.run(ProjectsService.class);
//    }

    @Value("${operations.projectsURL}")
    String serviceURL;


    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public String getProjects() throws Exception {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serviceURL)
                .queryParam("qualifiers", "TRK")
                .queryParam("q", "mongo");

//        return restTemplate.postForObject(serviceURL, createSearchProjectRequest(), String.class);
        ParameterizedTypeReference<RestPageImpl<Project>> responseType = new ParameterizedTypeReference<RestPageImpl<Project>>() {
        };

        ResponseEntity<RestPageImpl<Project>> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);

        List<Project> searchResult = result.getBody().getContent();
        for (Project c : searchResult)
            log.info(c.toString());

        ParameterizedTypeReference<RestPageImpl<Project>> responseType2 = new ParameterizedTypeReference<RestPageImpl<Project>>() {
        };

        result = restTemplate.exchange(url3, HttpMethod.GET, null, responseType);

        searchResult = result.getBody().getContent();
        result.getHeaders();
        log.info("issues:" + result.getBody().getTotalElements());
        for (Project c : searchResult)
            log.info(c.toString());

        return null;
    }


    private Object createSearchProjectRequest() {
//        AddOnAvailability addOnAvailability = new AddOnAvailability();
//        addOnAvailability.setCheckInDate("09/14/2017");
//        addOnAvailability.setCheckOutDate("09/16/2017");
//        addOnAvailability.setItemCode("");
//        addOnAvailability.setAddOnCategory("10");
//        return addOnAvailability;
        return null;
    }
}