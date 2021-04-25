package br.com.codenation.paymentmethods;

public enum PaymentMethod {

    CASH(new CashMethod()),
    DEBIT_CARD(new DebitCardMethod()),
    CREDIT_CARD(new CreditCardMethod()),
    TRANSFER(new TransferMethod());

    private PriceStrategy priceStrategy;

    PaymentMethod(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public PriceStrategy getPaymentStrategy() {
        return priceStrategy;
    }
}