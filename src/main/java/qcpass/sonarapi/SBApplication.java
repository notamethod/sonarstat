package qcpass.sonarapi;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SBApplication {
//
//    private static final Logger log = LoggerFactory.getLogger(SBApplication.class);
//
//    private String url="https://sonarcloud.io/api/components/search?qualifiers=TRK&q=mongo";
//    private String url3="https://sonarcloud.io/api/issues/search?componentKeys=ss14&resolved=false&types=VULNERABILITY";
//
//    private String url2="http://gturnquist-quoters.cfapps.io/api/random";
//
//    public static void main(String args[]) {
//        SpringApplication.run(SBApplication.class);
//    }
//
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
//
//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//
//
//        ParameterizedTypeReference<RestPageImpl<Project>> responseType = new ParameterizedTypeReference<RestPageImpl<Project>>() { };
//
//        ResponseEntity<RestPageImpl<Project>> result = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
//
//        List<Project> searchResult = result.getBody().getContent();
//        for (Project c : searchResult)
//            log.info(c.toString());
//
//        ParameterizedTypeReference<RestPageImpl<Project>> responseType2 = new ParameterizedTypeReference<RestPageImpl<Project>>() { };
//
//        result = restTemplate.exchange(url3, HttpMethod.GET, null, responseType);
//
//         searchResult = result.getBody().getContent();
//        result.getHeaders();
//        log.info("issues:"+result.getBody().getTotalElements());
//        for (Project c : searchResult)
//            log.info(c.toString());
//
//        return null;
//    }
}