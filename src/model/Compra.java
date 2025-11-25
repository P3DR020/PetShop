package model;

public class Compra {
    private Cliente cliente;
    private Produto produto;
    private FormaPagamento pagamento;
    private double valorBruto;
    private double valorTotal;

    public Compra(Cliente cliente, Produto produto, FormaPagamento pagamento) {
        this.cliente = cliente;
        this.produto = produto;
        this.pagamento = pagamento;
        this.valorBruto = produto.getPreco();
        this.valorTotal = pagamento.calcularPagamento(this.valorBruto);
    }

    public Cliente getCliente() { return cliente; }
    public Produto getProduto() { return produto; }
    public FormaPagamento getPagamento() { return pagamento; }
    public double getValorBruto() { return valorBruto; }
    public double getValorTotal() { return valorTotal; }

    @Override
    public String toString() {
        // usa produto.toString() caso não exista getNome()
        return String.format("Cliente: %s \n| Produto: %s \n| Valor: R$ %.2f \n| Total (com taxa): R$ %.2f",
                cliente.getNome(),
                produto.toString(),
                valorBruto,
                valorTotal);
    }
}