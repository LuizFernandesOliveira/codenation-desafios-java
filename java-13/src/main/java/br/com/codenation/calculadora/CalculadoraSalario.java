package br.com.codenation.calculadora;

public class CalculadoraSalario {
    double salary = 0;

    public long calcularSalarioLiquido(double salarioBase) {
        if (salarioBase < 1039) {
            return 0;
        } else {
            this.salary = salarioBase;
            calcularInss();
            calcularIRRF();
            return Math.round(this.salary);
        }
    }

    private void calcularInss() {
        if (this.salary <= 1500) {
            this.reduceSalaryByPercentage(8);
        } else if (this.salary <= 4000) {
            this.reduceSalaryByPercentage(9);
        } else {
            this.reduceSalaryByPercentage(11);
        }
    }

    private void calcularIRRF() {
        if (this.salary > 6000) {
            this.reduceSalaryByPercentage(15);
        } else if (this.salary > 3000) {
            this.reduceSalaryByPercentage(7.5);
        }
    }

    private void reduceSalaryByPercentage(double percentage) {
        this.salary -= this.salary * percentage / 100;
    }
}
