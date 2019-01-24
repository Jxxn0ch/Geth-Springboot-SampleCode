package me.springboot.gethwithmaven;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.web3j.utils.Convert;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;
import static org.web3j.utils.Convert.fromWei;
import static org.web3j.utils.Convert.toWei;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GethwithmavenApplicationTests {

    @Autowired
    private Web3jSampleService web3jSampleService;


    @Test
    public void testGetClientVersion() throws IOException {
        assertThat(web3jSampleService.getClientVersion());
    }

    @Test
    public void getAccount() {
        String JSONInput = "{\"jsonrpc\": \"2.0\", \"method\":\"eth_accounts\", \"params\":[], \"id\":1 }";
        web3jSampleService.callGethFunction(JSONInput);
    }

    @Test
    public void unlockAccount() {

        String account = "0x75910a0dbfc3f7999e1eceb259a5c7006ecaf09f";

        String JSONInput = "{\n" +
                "    \"jsonrpc\": \"2.0\", \n" +
                "    \"method\" : \"personal_unlockAccount\", \n" +
                "    \"params\"  : [\n" +
                "       \"" + account + "\", \n" +
                "       \"\", \n" +
                "       3600 \n" +
                "    ], \n" +
                "    \"id\" : 67 \n" +
                "} ";

        System.out.println(JSONInput);
        web3jSampleService.callGethFunction(JSONInput);
    }

    @Test
    public void sendTransaction() {

        String from = "0x16c562c738c48354dae1684612a413ddfad94ac9";
        String to = "0x75910a0dbfc3f7999e1eceb259a5c7006ecaf09f";

        String gas = "0x" + toWei("90000", Convert.Unit.WEI).toBigInteger().toString(16);
        String gasPrice = "0x" + toWei("20000000000", Convert.Unit.WEI).toBigInteger().toString(16);
        String value = "0x" +  toWei("1", Convert.Unit.ETHER).toBigInteger().toString(16);

        String JSONInput = "{\n" +
                "    \"jsonrpc\": \"2.0\", \n" +
                "    \"method\" : \"eth_sendTransaction\", \n" +
                "    \"params\"  : [{ \n" +
                "       \"from\"       : \"" + from + "\", \n" +
                "       \"to\"         : \"" + to + "\", \n" +
                "       \"gas\"        : \"" + gas + "\", \n" +
                "       \"gasPrice\"   : \"" + gasPrice + "\", \n" +
                "       \"value\"      : \"" + value + "\" \n" +
                "    }], \n" +
                "    \"id\" : 1 \n" +
                "} ";

        System.out.println(JSONInput);
        web3jSampleService.callGethFunction(JSONInput);
    }

    @Test
    public void minerStart() {

        String JSONInput = "{\n" +
                "    \"jsonrpc\": \"2.0\", \n" +
                "    \"method\" : \"miner_start\", \n" +
                "    \"params\"  : [], \n" +
                "    \"id\" : 74 \n" +
                "} ";

        System.out.println(JSONInput);
        web3jSampleService.callGethFunction(JSONInput);
    }

    @Test
    public void minerStop() {

        String JSONInput = "{\n" +
                "    \"jsonrpc\": \"2.0\", \n" +
                "    \"method\" : \"miner_stop\", \n" +
                "    \"params\"  : [], \n" +
                "    \"id\" : 74 \n" +
                "} ";

        System.out.println(JSONInput);
        web3jSampleService.callGethFunction(JSONInput);
    }


    @Test
    public void getBalance() {

        String account = "0x75910a0dbfc3f7999e1eceb259a5c7006ecaf09f";

        String JSONInput = "{\n" +
                "    \"jsonrpc\": \"2.0\", \n" +
                "    \"method\" : \"eth_getBalance\", \n" +
                "    \"params\"  : [\n" +
                "       \"" + account + "\", \n" +
                "       \"latest\" \n" +
                "    ], \n" +
                "    \"id\" : 1 \n" +
                "} ";

        System.out.println(JSONInput);
        GethResultVO result = web3jSampleService.callGethFunction(JSONInput);
        System.out.println(Integer.decode(result.getResult()));

        //System.out.println(account + "'s balance is " + fromWei(result.getResult(), Convert.Unit.ETHER).toBigInteger().toString(16);
    }

}

