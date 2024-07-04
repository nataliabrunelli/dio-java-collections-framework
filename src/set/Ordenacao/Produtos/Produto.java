package set.Ordenacao.Produtos;
import java.util.Objects;

public class Produto implements Comparable<Produto> {
  private String nome;
  private int quantidade;
  private double preco;
  private long codigo;


  public Produto(String nome, int quantidade, double preco, long codigo) {
    this.nome = nome;
    this.quantidade = quantidade;
    this.preco = preco;
    this.codigo = codigo;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getQuantidade() {
    return this.quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public double getPreco() {
    return this.preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public long getCodigo() {
    return this.codigo;
  }

  public void setCodigo(long codigo) {
    this.codigo = codigo;
  }


  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Produto)) {
            return false;
        }
        Produto produto = (Produto) o;
        return codigo == produto.codigo;
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo);
  }

  @Override
  public String toString() {
    return "{" +
      " nome='" + getNome() + "'" +
      ", quantidade='" + getQuantidade() + "'" +
      ", preco='" + getPreco() + "'" +
      ", codigo='" + getCodigo() + "'" +
      "}";
  }

  @Override
  public int compareTo(Produto p) {
    return nome.compareToIgnoreCase(p.getNome());
  }  
}
