package qcpass.sonarapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class RestPageImpl<T> extends PageImpl<T>{

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RestPageImpl(@JsonProperty("components") List<T> content,
                        @JsonProperty("paging") JsonNode pageable) {

       // "pageIndex":1,"pageSize":100,"total":1
        super(content, PageRequest.of(pageable.get("pageIndex").asInt(), pageable.get("pageIndex").asInt()), pageable.get("total").asLong());
    }

    public RestPageImpl(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public RestPageImpl(List<T> content) {
        super(content);
    }

    public RestPageImpl() {
        super(new ArrayList());
    }
}


