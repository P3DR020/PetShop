package model;

public class Credito implements FormaPagamento {
    @Override
    public double calcularPagamento(double valorBruto) {
        System.out.println("Pagamento no crédito tem 10% de acréscimo.");
        return valorBruto * 1.10; // 10% de acréscimo
    }
}
