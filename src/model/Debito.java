package model;

public class Debito implements FormaPagamento {
    @Override
    public double calcularPagamento(double valorBruto) {
      System.out.println("Pagamento no crédito tem 5% de acréscimo.");
        return valorBruto * 1.05; // 5% de acréscimo
    }
}