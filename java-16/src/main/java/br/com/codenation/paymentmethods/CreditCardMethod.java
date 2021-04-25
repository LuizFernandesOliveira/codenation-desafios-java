package br.com.codenation.paymentmethods;

public class CreditCardMethod implements PriceStrategy{
    @Override
    public Double calculate(Double price) {
        return price * 0.98;
    }
}
