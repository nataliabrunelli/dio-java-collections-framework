package map.Pesquisa.Estoque;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
  private Map<Long, Produto> estoqueMap;

  public EstoqueProdutos() {
    this.estoqueMap = new HashMap<>();
  }

  public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
    estoqueMap.put(cod, new Produto(nome, preco, quantidade));
  }

  public void exibirProdutos() {
    System.out.println(estoqueMap);
  }

  public String calcularValorTotalEstoque() {
    double estoqueValorTotal = 0;

    if (!estoqueMap.isEmpty()) {
      for (Produto p : estoqueMap.values()) {
        estoqueValorTotal += p.getPreco() * p.getQuantidade();
      }
    }
    DecimalFormat df = new DecimalFormat("#.00");
    return df.format(estoqueValorTotal);
  }

  public Produto obterProdutoMaisCaro() {
    Produto produtoMaisCaro = null;
    double maiorValor = Double.MIN_VALUE;

    if (!estoqueMap.isEmpty()) {
      for (Produto p : estoqueMap.values()) {
        if (p.getPreco() > maiorValor) {
          maiorValor = p.getPreco();
          produtoMaisCaro = p;
        }
      }
    }

    return produtoMaisCaro;
  }

  public Produto obterProdutoMaisBarato() {
    Produto produtoMaisBarato = null;
    double menorValor = Double.MAX_VALUE;

    if (!estoqueMap.isEmpty()) {
      for (Produto p : estoqueMap.values()) {
        if (p.getPreco() < menorValor) {
          menorValor = p.getPreco();
          produtoMaisBarato = p;
        }
      }
    }
    return produtoMaisBarato;
  }

  public Produto obterProdutoMaiorQuantidadeEPreco() {
    Produto maiorQuantidadeEPreco = null;
    double maiorValorEQuantidade = Double.MIN_VALUE;

    if (!estoqueMap.isEmpty()) {
      for (Produto p : estoqueMap.values()) {
        if ((p.getPreco() * p.getQuantidade()) > maiorValorEQuantidade) {
          maiorValorEQuantidade = p.getPreco() * p.getQuantidade();
          maiorQuantidadeEPreco = p;
        }
      }
    }

    return maiorQuantidadeEPreco;
  }

  public static void main(String[] args) {
    EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

    estoqueProdutos.adicionarProduto(001, "Produto 1", 5, 0.99);
    estoqueProdutos.adicionarProduto(002, "Produto 2", 3, 5.40);
    estoqueProdutos.adicionarProduto(003, "Produto 3", 1, 45.0);
    estoqueProdutos.adicionarProduto(004, "Produto 4", 12, 1.90);
    estoqueProdutos.adicionarProduto(003, "Produto 5", 1, 10.70);

    // System.out.println("R$ " + estoqueProdutos.calcularValorTotalEstoque());
    // System.out.println(estoqueProdutos.obterProdutoMaisBarato());
    // System.out.println(estoqueProdutos.obterProdutoMaisCaro());
    // System.out.println(estoqueProdutos.obterProdutoMaiorQuantidadeEPreco());
    estoqueProdutos.exibirProdutos();
  }
}
