package com.cryptoapis.blockchains.bitcoin.services;

import com.cryptoapis.abstractServices.AbstractWebhookService;
import com.cryptoapis.models.ApiError;
import com.cryptoapis.models.Webhook;
import com.cryptoapis.utils.config.EndpointConfig;
import javafx.util.Pair;
import org.codehaus.jettison.json.JSONException;

import java.util.List;

public class BtcWebhookService extends AbstractWebhookService {
    private static final String PATH = "/{0}/bc/{1}/{2}/hooks/{3}";

    public BtcWebhookService(EndpointConfig endpointConfig) {
        super(endpointConfig);
    }

    @Override
    protected String getPath() {
        return PATH;
    }

    @Override
    public Pair<Webhook, ApiError> createNewBlockWh(String webhookUrl) {
        return super.createNewBlockWh(webhookUrl);
    }

    @Override
    public Pair<Webhook, ApiError> createAddressWh(String webhookUrl, String address) {
        return super.createAddressWh(webhookUrl, address);
    }

    @Override
    public Pair<Webhook, ApiError> createConfirmedTxWh(String webhookUrl, int confirmations, String transaction) {
        return super.createConfirmedTxWh(webhookUrl, confirmations, transaction);
    }

    @Override
    public Pair<Webhook, ApiError> createUnconfirmedTxWh(String webhookUrl) {
        return super.createUnconfirmedTxWh(webhookUrl);
    }

    @Override
    public Pair<String, ApiError> deleteWebhook(String whUuid) {
        return super.deleteWebhook(whUuid);
    }

    @Override
    public Pair<List<Webhook>, ApiError> listWebhooks() throws JSONException {
        return super.listWebhooks();
    }
}
