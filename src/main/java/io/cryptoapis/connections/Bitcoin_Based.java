package io.cryptoapis.connections;

import io.cryptoapis.blockchains.bitcoin_based.services.*;
import io.cryptoapis.utils.config.EndpointConfig;

abstract class Bitcoin_Based extends ConnectionConstructor {
    protected TransactionService transactionService;
    private BlockchainService blockchainService;
    private BlockService blockService;
    private AddressService addressService;
    private WalletService walletService;
    private WebhookService webhookService;
    private PaymentService paymentService;

    public TransactionService getTransactionService() {
        return transactionService;
    }

    public BlockchainService getBlockchainService() {
        return blockchainService;
    }

    public BlockService getBlockService() {
        return blockService;
    }

    public WalletService getWalletService() {
        return walletService;
    }

    public AddressService getAddressService() {
        return addressService;
    }

    public WebhookService getWebhookService() {
        return webhookService;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public Bitcoin_Based(EndpointConfig endpointConfig) {
        initServices(endpointConfig);
    }

    protected void initServices(EndpointConfig endpointConfig) {
        try {
            this.blockchainService = getConstructor(BlockchainService.class).newInstance(endpointConfig);
            this.blockService = getConstructor(BlockService.class).newInstance(endpointConfig);
            this.addressService = getConstructor(AddressService.class).newInstance(endpointConfig);
            this.walletService = getConstructor(WalletService.class).newInstance(endpointConfig);
            this.transactionService = getConstructor(TransactionService.class).newInstance(endpointConfig);
            this.webhookService = getConstructor(WebhookService.class).newInstance(endpointConfig);
            this.paymentService = getConstructor(PaymentService.class).newInstance(endpointConfig);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
