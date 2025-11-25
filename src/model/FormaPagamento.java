package model;

/**
 * Interface FormaPagamento
 * Define o contrato para cálculo de pagamento
 */
public interface FormaPagamento {
    double calcularPagamento(double valorBruto);
}
