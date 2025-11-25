package model;

public class Dinheiro implements FormaPagamento {
    @Override
    public double calcularPagamento(double valorBruto) {
        return valorBruto; // Sem acréscimo
    }
}
