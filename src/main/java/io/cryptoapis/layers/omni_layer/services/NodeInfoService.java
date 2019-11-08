package io.cryptoapis.layers.omni_layer.services;

import io.cryptoapis.abstractServices.AbstractServicesConfig;
import io.cryptoapis.common_models.ApiResponse;
import io.cryptoapis.utils.config.EndpointConfig;
import io.cryptoapis.utils.enums.HttpsRequestsEnum;
import io.cryptoapis.utils.rest.WebServices;

public class NodeInfoService extends AbstractServicesConfig {

    private static final String PATH = "/{0}/bc/{1}/omni/{2}/info";

    protected NodeInfoService(EndpointConfig endpointConfig) {
        super(endpointConfig);
    }

    @Override
    protected String getPath() {
        return PATH;
    }

    public ApiResponse getNodeInfo() {
        return WebServices.httpsRequest(WebServices.formatUrl(url, endpointConfig, null), HttpsRequestsEnum.GET.name(), endpointConfig, null);
    }
}
