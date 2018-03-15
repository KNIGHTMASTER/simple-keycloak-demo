package com.zisal.security.client.two;

import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 3/15/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class OAuthRestClient {

    public String[] get(String p_AccessToken, String p_UrlTarget) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        System.out.println("Access Token "+p_AccessToken);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer ".concat(p_AccessToken));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String[]> response = restTemplate.exchange(p_UrlTarget, HttpMethod.GET, entity, String[].class);
        return response.getBody();
    }

    public OAuthResponseDTO getAccessToken(String p_UrlIdentityBroker, String p_UserName, String p_Password, String p_ClientId, String p_ClientSecret) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("username", p_UserName);
        map.add("password", p_Password);
        map.add("grant_type", "password");
        map.add("client_id", p_ClientId);
        map.add("client_secret", p_ClientSecret);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<OAuthResponseDTO> response = restTemplate.postForEntity(p_UrlIdentityBroker, request , OAuthResponseDTO.class );

        return response.getBody();
    }
}
