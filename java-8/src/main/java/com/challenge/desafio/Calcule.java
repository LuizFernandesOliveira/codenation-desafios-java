package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class Calcule {

    @Somar()
    BigDecimal salario = new BigDecimal(30);

    @Subtrair()
    BigDecimal despesa1 = new BigDecimal(10);

    BigDecimal despesa2 = new BigDecimal(11);

    Integer despesa3 = 10;

}
