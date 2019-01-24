package me.springboot.gethwithmaven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

import java.io.IOException;

/**
 * Sample service to demonstrate web3j bean being correctly injected.
 */
@Service
public class Web3jSampleService {

    @Autowired
    private Web3j web3j;
    private static final String url = "http://127.0.0.1:8545";

    public String getClientVersion() throws IOException {
        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        System.out.println(clientVersion);
        return clientVersion;
    }

    public GethResultVO callGethFunction(String JSONInput) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity param= new HttpEntity(JSONInput, headers);

        RestTemplate restTemplate = new RestTemplate();
        GethResultVO result = restTemplate.postForObject(url, param, GethResultVO.class);
        System.out.println(result.toString());

        return result;
    }

}
