package com.cryptoapis.blockchains.ethereum.services;

import com.cryptoapis.blockchains.ethereum.models.EthTokenTransfer;
import com.cryptoapis.utils.enums.KeyType;
import com.cryptoapis.abstractServices.AbstractServicesConfig;
import com.cryptoapis.common_models.ApiResponse;
import com.cryptoapis.utils.config.EndpointConfig;
import com.cryptoapis.utils.enums.HttpsRequestsEnum;
import com.cryptoapis.utils.rest.WebServices;
import java.math.BigDecimal;
import java.math.BigInteger;

public class EthTokenService extends AbstractServicesConfig {
    private static final String PATH = "/{0}/bc/{1}/{2}/tokens/{3}";

    public EthTokenService(EndpointConfig endpointConfig) {
        super(endpointConfig);
    }

    @Override
    protected String getPath() {
        return PATH;
    }

    public ApiResponse getTokenBalance(String address, String contract) {
        String endpoint = String.format("%s/%s/balance", address, contract);

        return WebServices.httpsRequest(WebServices.formatUrl(url, endpointConfig, endpoint), HttpsRequestsEnum.GET.name(), endpointConfig, null);
    }

    public ApiResponse transferPvt(String fromAddress, String toAddress, String contract, BigInteger gasPrice, BigInteger gasLimit, BigDecimal token, String privateKey) {
        String body = createTokenTransaction(fromAddress, toAddress, contract, gasPrice, gasLimit, token, KeyType.PrivateKey, privateKey);

        return broadcastTransfer(body);
    }

    public ApiResponse transferPwd(String fromAddress, String toAddress, String contract, BigInteger gasPrice, BigInteger gasLimit, BigDecimal token, String password) {
        String body = createTokenTransaction(fromAddress, toAddress, contract, gasPrice, gasLimit, token, KeyType.Password, password);

        return broadcastTransfer(body);
    }

    public ApiResponse getTokensPerAddress(String address) {
        String endpoint = String.format("address/%s", address);

       return WebServices.httpsRequest(WebServices.formatUrl(url, endpointConfig, endpoint), HttpsRequestsEnum.GET.name(), endpointConfig, null);
    }

    private String createTokenTransaction(String fromAddress, String toAddress, String contract, BigInteger gasPrice, BigInteger gasLimit, BigDecimal token, KeyType keyType, String key) {
        EthTokenTransfer ethToken = EthTokenTransfer.createTokenTransaction(fromAddress, toAddress, contract, gasPrice, gasLimit, token, keyType, key);
        return ethToken.toString();
    }

    private ApiResponse broadcastTransfer(String body) {
        return WebServices.httpsRequest(WebServices.formatUrl(url, endpointConfig, "transfer"), HttpsRequestsEnum.POST.name(), endpointConfig, body);
    }
}
