package io.cryptoapis.blockchains.ethereum.services;

import io.cryptoapis.common_models.ApiResponse;
import io.cryptoapis.utils.enums.HttpsRequestsEnum;
import io.cryptoapis.abstractServices.AbstractServicesConfig;
import io.cryptoapis.utils.config.EndpointConfig;
import io.cryptoapis.utils.rest.WebServices;

public class EthBlockchainService extends AbstractServicesConfig {
    private static final String PATH = "/{0}/bc/{1}/{2}/info";

    public EthBlockchainService(EndpointConfig endpointConfig) {
        super(endpointConfig);
    }

    @Override
    protected String getPath() {
        return PATH;
    }

    public ApiResponse getBlockchainInfo() {
       return WebServices.httpsRequest(WebServices.formatUrl(url, endpointConfig, null), HttpsRequestsEnum.GET.name(), endpointConfig, null);
    }
}
