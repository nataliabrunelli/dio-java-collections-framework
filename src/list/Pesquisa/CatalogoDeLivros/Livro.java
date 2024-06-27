package list.Pesquisa.CatalogoDeLivros;

public class Livro {
  // Atributos
  private String titulo, autor;
  private int ano;

  public Livro(String titulo, String autor, int ano) {
    this.titulo = titulo;
    this.autor = autor;
    this.ano = ano;
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

  public int getAno() {
    return this.ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  @Override
  public String toString() {
    return "{" +
      " titulo='" + getTitulo() + "'" +
      ", autor='" + getAutor() + "'" +
      ", ano='" + getAno() + "'" +
      "}";
  }
}
