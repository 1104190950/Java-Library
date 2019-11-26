package io.cryptoapis.blockchains.bitcoin_based.services;

import io.cryptoapis.abstractServices.AbstractWebhookService;
import io.cryptoapis.common_models.ApiResponse;
import io.cryptoapis.utils.config.EndpointConfig;

import java.util.Map;

public class WebhookService extends AbstractWebhookService {
    private static final String PATH = "/{0}/bc/{1}/{2}/hooks{3}";

    public WebhookService(EndpointConfig endpointConfig) {
        super(endpointConfig);
    }

    @Override
    protected String getPath() {
        return PATH;
    }

    @Override
    public ApiResponse createNewBlockWh(String webhookUrl) {
        return super.createNewBlockWh(webhookUrl);
    }

    @Override
    public ApiResponse createAddressWh(String webhookUrl, String address, int confirmations) {
        return super.createAddressWh(webhookUrl, address, confirmations);
    }

    @Override
    public ApiResponse createConfirmedTxWh(String webhookUrl, String transaction, int confirmations) {
        return super.createConfirmedTxWh(webhookUrl, transaction, confirmations);
    }

    @Override
    public ApiResponse createTransactionConfirmationsWh(String webhookUrl, String address, int confirmations) {
        return super.createTransactionConfirmationsWh(webhookUrl, address, confirmations);
    }

    @Override
    public ApiResponse deleteWebhook(String webhookId) {
        return super.deleteWebhook(webhookId);
    }

    @Override
    public ApiResponse deleteAllWebhooks() {
        return super.deleteAllWebhooks();
    }

    @Override
    public ApiResponse listWebhooks(Map<String, String> map) {
        return super.listWebhooks(map);
    }
}
