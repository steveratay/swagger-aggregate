package biz.te2.services.swaggeraggregate.controller

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Controller
class SwaggerController {

    RestTemplate restTemplate;

    public SwaggerController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping(path = "")
    String redirectToSwagger() {
        return "redirect:/swagger-ui.html"
    }

    @GetMapping(path = "/specs/{service}/groups/{group}")
    @ResponseBody ResponseEntity<String> proxySpec(@PathVariable("service") String service, @PathVariable("group") String group) {

        HttpHeaders headers = new HttpHeaders()
        headers.set("Accept", "application/json")

        String url = "http://{service}/v2/api-docs"
        Map<String, String> params = new HashMap<String, String>()
        params.put("service", service);
        URI uri = UriComponentsBuilder.fromUriString(url)
                .buildAndExpand(params)
                .toUri()
        uri = UriComponentsBuilder
                .fromUri(uri)
                .queryParam("group", group)
                .build()
                .toUri()

        HttpEntity requestEntity = new HttpEntity<>(headers)

        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class)
        return responseEntity
    }
}
