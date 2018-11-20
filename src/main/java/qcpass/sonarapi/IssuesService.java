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
import qcpass.domain.Issue;

import java.util.List;

@org.springframework.stereotype.Component
public class IssuesService {

    private static final Logger log = LoggerFactory.getLogger(IssuesService.class);

    private String url = "https://sonarcloud.io/api/components/search?qualifiers=TRK&q=mongo";
    private String url3 = "https://sonarcloud.io/api/issues/search?componentKeys=ss14&resolved=false&types=VULNERABILITY";

    private String url2 = "http://gturnquist-quoters.cfapps.io/api/random";

    private RestTemplate restTemplate;

    @Autowired
    public IssuesService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }


    @Value("${operations.issuesURL}")
    String serviceURL;


    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public String getIssuesForModule() throws Exception {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serviceURL)
                .queryParam("componentKeys", "xx")
                .queryParam("resolved", "false")
                .queryParam("types", "VULNERABILITY");
//                .queryParam("types", "BUG");

//        return restTemplate.postForObject(serviceURL, createSearchProjectRequest(), String.class);
        ParameterizedTypeReference<RestPageImpl<Issue>> responseType = new ParameterizedTypeReference<RestPageImpl<Issue>>() {
        };
        System.out.println(builder.toUriString());
        ResponseEntity<RestPageImpl<Issue>> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);

        List<Issue> searchResult = result.getBody().getContent();
        for (Issue c : searchResult)
            log.info(c.toString());


        return null;
    }
    public String getIssuesForModule2(String key) throws Exception {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serviceURL)
                .queryParam("componentKeys", key)
                .queryParam("resolved", "false")
                .queryParam("types", "VULNERABILITY");
//                .queryParam("types", "BUG");

//        return restTemplate.postForObject(serviceURL, createSearchProjectRequest(), String.class);
        ParameterizedTypeReference<RestPageImpl<Issue>> responseType = new ParameterizedTypeReference<RestPageImpl<Issue>>() {
        };
        System.out.println(builder.toUriString());
        ResponseEntity<RestPageImpl<Issue>> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);

        List<Issue> searchResult = result.getBody().getContent();
        for (Issue c : searchResult)
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

    public void hello() {
        System.out.println("HELLO");
    }
}