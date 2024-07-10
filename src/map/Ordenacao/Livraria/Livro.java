package map.Ordenacao.Livraria;

public class Livro {
  private String titulo, autor;
  private double preco;


  public Livro(String titulo, String autor, double preco) {
    this.titulo = titulo;
    this.autor = autor;
    this.preco = preco;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return this.autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public double getPreco() {
    return this.preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }


  @Override
  public String toString() {
    return "{" +
      " titulo='" + getTitulo() + "'" +
      ", autor='" + getAutor() + "'" +
      ", preco='" + getPreco() + "'" +
      "}";
  }  
}
