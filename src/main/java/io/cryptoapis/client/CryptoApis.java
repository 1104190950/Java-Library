package io.cryptoapis.client;

import io.cryptoapis.connections.*;
import io.cryptoapis.utils.config.EndpointConfig;
import io.cryptoapis.utils.constants.CryptoApisConstants;

public class CryptoApis implements CryptoApisConstants {
    private String apiKey;

    public CryptoApis(String apiKey) {
        this.apiKey = apiKey;
    }

    public Ethereum connectToEth(String network) {
        return new Ethereum(setBlockChainConfig(CryptoApisConstants.ETHEREUM, network));
    }

    public Ethereum_Classic connectToEtc(String network) {
        return new Ethereum_Classic(setBlockChainConfig(CryptoApisConstants.ETHEREUM_CLASSIC, network));
    }

    public Bitcoin connectToBtc(String network) {
        return new Bitcoin(setBlockChainConfig(CryptoApisConstants.BITCOIN, network));
    }

    public Litecoin connectToLtc(String network) {
        return new Litecoin(setBlockChainConfig(CryptoApisConstants.LITECOIN, network));
    }

    public Bitcoin_Cash connectToBch(String network) {
        return new Bitcoin_Cash(setBlockChainConfig(CryptoApisConstants.BITCOIN_CASH, network));
    }

    public Dogecoin connectToDoge(String network) {
        return new Dogecoin(setBlockChainConfig(CryptoApisConstants.DOGECOIN, network));
    }

    public Dash connectToDash(String network) {
        return new Dash(setBlockChainConfig(CryptoApisConstants.DASH, network));
    }

    public Zilliqa connectToZilliqa(String network) {
        return new Zilliqa(setBlockChainConfig(CryptoApisConstants.ZIL, network));
    }

    public Exchanges connectToExchanges() {
        return new Exchanges(setConfig());
    }

    private EndpointConfig setBlockChainConfig(String blockchain, String network) {
        EndpointConfig newConfig = setConfig();
        newConfig.setBlockchain(blockchain);
        newConfig.setNetwork(network);
        return newConfig;
    }

    private EndpointConfig setConfig() {
        return new EndpointConfig(CryptoApisConstants.VERSION_V1, this.apiKey);
    }
}
