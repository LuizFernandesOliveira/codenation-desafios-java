package br.com.codenation.paymentmethods;

public class CashMethod implements PriceStrategy{
    @Override
    public Double calculate(Double price) {
        return price * 0.9;
    }
}
