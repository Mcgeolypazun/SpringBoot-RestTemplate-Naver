package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.Req.Header;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import java.net.URI;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RestTemplateService {

    public UserResponse hello() {
        URI uri = UriComponentsBuilder
            .fromUriString("http://localhost:9090")
            .path("/api/server/hello")
            .queryParam("name", "aaaaa")
            .queryParam("age", 133)
            .build()
            .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);
        System.out.println(uri.toString());
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());
        return result.getBody();
    }

    public UserResponse post() {

        URI uri = UriComponentsBuilder
            .fromUriString("http://localhost:9090")
            .path("/api/server/user/{userId}/name/{userName}")
            .encode()
            .build()
            .expand("100","steve")
            .toUri();
        System.out.println(uri);

        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri,req,UserResponse.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();
    }

    public UserResponse exchange(){
        URI uri = UriComponentsBuilder
            .fromUriString("http://localhost:9090")
            .path("/api/server/user/{userId}/name/{userName}")
            .encode()
            .build()
            .expand("100","steve")
            .toUri();
        System.out.println(uri);

        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        RequestEntity<UserRequest> requestEntity = RequestEntity
            .post(uri)
            .contentType(MediaType.APPLICATION_JSON)
            .header("x-authorization","abcd")
            .header("custom-header","fffff")
            .body(req);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity,UserResponse.class);
        return response.getBody();
    }

    public Req<UserResponse> genericExchange(){
        URI uri = UriComponentsBuilder
            .fromUriString("http://localhost:9090")
            .path("/api/server/user/{userId}/name/{userName}")
            .encode()
            .build()
            .expand("100","steve")
            .toUri();
        System.out.println(uri);

        UserRequest userRequest = new UserRequest();
        userRequest.setName("steve");
        userRequest.setAge(10);

        Req<UserRequest> req = new Req<UserRequest>();
        req.setHeader(
            new Header()
        );

        req.setResBody(
            userRequest
        );

        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
            .post(uri)
            .contentType(MediaType.APPLICATION_JSON)
            .header("x-authorization","abcd")
            .header("custom-header","fffff")
            .body(req);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Req<UserResponse>> response = restTemplate.exchange(requestEntity,new ParameterizedTypeReference<Req<UserResponse>>(){});

        return response.getBody();
    }
}
