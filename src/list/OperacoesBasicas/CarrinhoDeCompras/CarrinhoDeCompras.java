package list.OperacoesBasicas.CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
  // Implemantando como uma LISTA de ITENS
  private List<Item> itemCarrinho;

  // Construindo por padrão como já uma lista vazia

  public CarrinhoDeCompras() {
    this.itemCarrinho = new ArrayList<>();
  }

  public void adicionarItem(String nome, double preco, int quantidade) {
    itemCarrinho.add(new Item(nome, preco, quantidade));
  }

  public void removerItem(String nome) {
    List<Item> itensParaRemover = new ArrayList<>();

    for (Item i : itemCarrinho) {
      if (i.getNome() == nome) {
        itensParaRemover.add(i);
      }
    }

    itemCarrinho.removeAll(itensParaRemover);
  }

  public void calcularValorTotal() {
    double soma = 0;

    for (Item is : itemCarrinho) {
      soma += is.getPreco() * is.getQuantidade();
    }

    System.out.println("O total do carrinho é: R$" + soma);
  }

  public void quantidadeDeItensDiferentes() {

    if (itemCarrinho.size() == 0) {
      System.out.println("O carrinho está vazio.");
    } else {
      System.out.println(itemCarrinho.size());
    }
  }

  public void exibirItens() {
    System.out.println(itemCarrinho);
  }

  public static void main(String[] args) {
    CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

    carrinho.adicionarItem("Livro 1", 19.9, 2);
    carrinho.adicionarItem("Livro 2", 16.7, 1);

    carrinho.quantidadeDeItensDiferentes();
    carrinho.calcularValorTotal();
  }
}
