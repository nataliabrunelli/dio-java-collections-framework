package set.Ordenacao.Produtos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
  private Set<Produto> produtoSet;


  public CadastroProdutos() {
    this.produtoSet = new HashSet<>();
  }

  public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
    this.produtoSet.add(new Produto(nome, quantidade, preco, cod));
  }

  public Set<Produto> exibirProdutosPorNome() {
    // Para colocá-los em ordem alfabética, Produto implementa a Comparable!
    // Na hora de instanciar NÃO vai ser um HashSet, porque ele não permite organizar a ordem!
    
    Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);

    // NÃO precisa utilizar a Collections, porque ela recebe List! O TreeSet já reconhece a ordenação.

    return produtosPorNome;
  }

  public Set<Produto> exibirProdutosPorPreco() {
    // Passando o Comparator como parâmetro do TreeSet:
    Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());

    // produtosPorPreco está vazio, então tem que add produtoSet
    produtosPorPreco.addAll(produtoSet);

    return produtosPorPreco;
  }

  public static void main(String[] args) {
    CadastroProdutos cadastroProdutos = new CadastroProdutos();

    cadastroProdutos.adicionarProduto(11l, "Produto 1", 18.5, 1);
    cadastroProdutos.adicionarProduto(22l, "Produto 2", 19.9, 3);
    cadastroProdutos.adicionarProduto(33l, "Produto 3", 5.5, 7);
    cadastroProdutos.adicionarProduto(14l, "Produto 4", 1.9, 2);

    // System.out.println(cadastroProdutos.produtoSet);
    // System.out.println(cadastroProdutos.exibirProdutosPorNome());
    System.out.println(cadastroProdutos.exibirProdutosPorPreco());
  }
}
