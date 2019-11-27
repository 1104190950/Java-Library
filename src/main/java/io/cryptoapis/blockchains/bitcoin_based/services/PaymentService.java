package io.cryptoapis.blockchains.bitcoin_based.services;

import io.cryptoapis.abstractServices.AbstractServicesConfig;
import io.cryptoapis.blockchains.bitcoin_based.models.Payment;
import io.cryptoapis.common_models.ApiResponse;
import io.cryptoapis.utils.Utils;
import io.cryptoapis.utils.config.EndpointConfig;
import io.cryptoapis.utils.enums.HttpsRequestsEnum;
import io.cryptoapis.utils.rest.WebServices;
import org.apache.commons.lang.StringUtils;

public class PaymentService extends AbstractServicesConfig {
    private static final String PATH = "/{0}/bc/{1}/{2}/payments{3}";

    protected PaymentService(EndpointConfig endpointConfig) {
        super(endpointConfig);
    }

    @Override
    protected String getPath() {
        return PATH;
    }

    public ApiResponse createPFPwd(String from, String to, String callback, String walletName, String password, Integer confirmations, Double fee) {
        Payment payment = createPF(from, to, callback, walletName, password, confirmations, fee);

        return WebServices.httpsRequest(WebServices.formatUrl(url, endpointConfig, StringUtils.EMPTY), HttpsRequestsEnum.POST.name(), endpointConfig, payment.toString());
    }

    public ApiResponse deletePF(String paymentID) {
        String endpoint = String.format("/%s" , paymentID);

        return Utils.deleteUnit(endpoint, url, endpointConfig);
    }

    public ApiResponse listPayments() {
        return getPayments(StringUtils.EMPTY);
    }

    public ApiResponse listPastPayments() {
        return getPayments("/history");
    }

    private Payment createPF(String from, String to, String callback, String walletName, String password, Integer confirmations, Double fee) {
       return Payment.createPayment(from, to, callback, walletName, password, confirmations, fee);
    }

    private ApiResponse getPayments(String endpoint) {
        return WebServices.httpsRequest(WebServices.formatUrl(url, endpointConfig, endpoint), HttpsRequestsEnum.GET.name(), endpointConfig, null);
    }
}
