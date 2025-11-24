package model;

/**
 * Enum FormaPagamento
 * Representa as formas de pagamento aceitas no sistema.
 *
 * Utilizar enum garante que só existam estas opções,
 * evitando erros de digitação ou valores inválidos.
 */
public enum FormaPagamento {
  DINHEIRO,  // Pagamento em espécie
  CARTAO,    // Pagamento com cartão (crédito/débito)
  PIX        // Pagamento via PIX
}
