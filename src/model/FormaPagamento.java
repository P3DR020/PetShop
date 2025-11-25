package model;

/**
 * Interface FormaPagamento
 * Define o contrato para cálculo de pagamento
 */
public interface FormaPagamento {
    double calcularPagamento(double valorBruto);
}


/**
 * Enum FormaPagamento
 * Representa as formas de pagamento aceitas no sistema.
 *
 * Utilizar enum garante que só existam estas opções,
 * evitando erros de digitação ou valores inválidos.
 */
//public enum FormaPagamento {
 // DINHEIRO,  // Pagamento em espécie
  //CARTAO,    // Pagamento com cartão (crédito/débito)
 // PIX        // Pagamento via PIX
//}




// public interface FormaPagamento {
//     double calcularPagamento(double valorBruto);
// }

// 	public class Credito implements FormaPagamento {
// 	    @Override
// 	    public double calcularPagamento(double valorBruto) {
// 	        return valorBruto * 1.10;
// 	    }
// 	}
//     public class Debito implements FormaPagamento {
//         @Override
//         public double calcularPagamento(valorBruto) {
//             return valorBruto * 1.05;
//     }
// }