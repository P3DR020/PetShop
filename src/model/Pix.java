package model;

public class Pix implements FormaPagamento {
    @Override
    public double calcularPagamento(double valorBruto) {
        return valorBruto; // Sem acréscimo
    }
}
