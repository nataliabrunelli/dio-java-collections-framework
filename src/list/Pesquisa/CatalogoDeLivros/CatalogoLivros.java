package list.Pesquisa.CatalogoDeLivros;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
  // Lista de Objetos como Atributos
  private List<Livro> listaLivro = new ArrayList<>();

  // Construtor instanciando já uma lista vazia

  public CatalogoLivros() {
    this.listaLivro = new ArrayList<>();
  }
  
  public void adicionarLivro(String titulo, String autor, int ano) {
    listaLivro.add(new Livro(titulo, autor, ano));
  }

  // Pesquisando e retornando uma lista de livros, porque pode ter mais de um/autor
  public List<Livro> pesquisarPorAutor(String autor) {
    List<Livro> livrosPorAutor = new ArrayList<>();

    if (!listaLivro.isEmpty()) {
      for (Livro l : listaLivro) {
        if (l.getAutor().equalsIgnoreCase(autor)) {
          livrosPorAutor.add(l);
        }
      }
    } else {
      System.out.println("Lista vazia.");
    }

    return livrosPorAutor;
  }

  public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
    List<Livro> livrosPorIntervaloAnos = new ArrayList<>();

    if (!listaLivro.isEmpty()) {
      for (Livro l : listaLivro) {
        if (l.getAno() >= anoInicial && l.getAno() <= anoFinal) {
          livrosPorIntervaloAnos.add(l);
        }
      }
    } else {
      System.out.println("Lista vazia.");
    }

    return livrosPorIntervaloAnos;
  }

  public Livro pesquisarPorTitulo(String titulo) {
    // Instanciando um objeto vazio
    Livro livroPorTitulo = null;

    if (!listaLivro.isEmpty()) {
      for (Livro l : listaLivro) {
        if (l.getTitulo().equalsIgnoreCase(titulo)) {
          livroPorTitulo = l;
          break; 
          //não precisa continuar o laço depois de encontrá-lo
        } 
      }
    } else {
      System.out.println("Lista vazia.");
    }

    return livroPorTitulo;
  }

  public static void main(String[] args) {
    // Instancioando CatalogoLivros
    CatalogoLivros catalogoLivros = new CatalogoLivros();

    catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 1990);
    catalogoLivros.adicionarLivro("Livro 2", "Autor 1", 2000);
    catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2000);
    catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2015);
    catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 2010);

    System.out.println(catalogoLivros.pesquisarPorAutor("Autor 1"));
    System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2000,2009));
    System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 2"));
  }
}
