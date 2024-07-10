package map.Ordenacao.Livraria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class LivrariaOnline {
  private Map<String, Livro> livrariaMap;


  public LivrariaOnline() {
    this.livrariaMap = new HashMap<>();
  }

  public void adicionarLivro(String link, String titulo, String autor, double preco) {
    livrariaMap.put(link, new Livro(titulo, autor, preco));
  }

  public void removerLivro(String titulo) {
    // O método .remove sempre utiliza a chava, então é preciso pegá-la e armazená-la para remover!
    // Criando uma List, já que vai mexer com um Objeto e não direto com uma variável, para guardar as chaves:
    List <String> chavesParaRemover = new ArrayList<>();

    if (!livrariaMap.isEmpty()) {
      for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
        // Buscando e comparando o título
        if (entry.getValue().getTitulo().equals(titulo)) {
          // pegando e guardando a chave do título:
          chavesParaRemover.add(entry.getKey());
        }
      }
      // Como o .remove pega a chave e não a list, percorremos a list e armazenamos numa varíavel pra passar no método:
      for (String chave : chavesParaRemover) {
        livrariaMap.remove(chave);
      }
    }
  }

  public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
    /* Criando uma lista para armazenar as entradas do mapa livrariaMap:
     * livrariaMap.entrySet() retorna um conjunto de todas as entradas (chave-valor) do mapa livrariaMap
     * Isso é feito para facilitar a ordenação das entradas, já que não se pode ordenar diretamente um Map */
    List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrariaMap.entrySet());

    // Collections.sort() ordena a lista livrosParaOrdenarPorPreco com base em um critério de comparação definido pelo Comparator
    Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());

    /* Criando um novo mapa (LinkedHashMap) para armazenar os livros ordenados por preço:
     * LinkedHashMap mantém a ordem de inserção dos elementos sem introduzir complexidade desnecessária associada à estrutura de árvore de TreeMap */
    Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

    /* O loop for-each percorre cada Map.Entry na lista ordenada (livrosParaOrdenarPorPreco) e utiliza o método .put() para adicionar cada entrada ao novo mapa livrosOrdenadosPorPreco
     * Como livrosParaOrdenar é uma List e não Map, NÃO usa o .entrySet()
     */
    for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
      livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
    }

    return livrosOrdenadosPorPreco;
  }

  public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
    List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livrariaMap.entrySet());

    Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());

    Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

    for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
      livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
    }

    return livrosOrdenadosPorAutor;
  }

  public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
    // Criar um LinkedHashMap para armazenar os livros cujo autor corresponde ao autor fornecido:
    Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();

    // Iterar sobre as entradas do mapa original (livrariaMap):
    for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
      
      // Obter o livro da entrada atual:
      Livro livro = entry.getValue();

      if (livro.getAutor().equals(autor)) {
        livrosPorAutor.put(entry.getKey(), livro);
      }
    }

    return livrosPorAutor;
  }

  public List<Livro> obterLivroMaisCaro() {
    // Inicializa uma lista para armazenar os livros com o preço mais alto
    List<Livro> livrosMaisCaros = new ArrayList<>();
    // Inicializa o preço mais alto com um valor muito baixo inicialmente
    double precoMaisAlto = Double.MIN_VALUE;

    if (!livrariaMap.isEmpty()) {
      // Iterando com o Objeto para pegar o preço mais alto:
      for (Livro livro : livrariaMap.values()) {
        if (livro.getPreco() > precoMaisAlto) {
          precoMaisAlto = livro.getPreco();
        }
      }
    } else {
      throw new NoSuchElementException("A livraria está vazia!");
    }

    // Iterando agora com o map para adicionar os livros com preço mais alto à lista:
    for(Map.Entry<String, Livro> entry: livrariaMap.entrySet()) {
      if(entry.getValue().getPreco() == precoMaisAlto) {
        Livro livroComPrecoMaisAlto = livrariaMap.get(entry.getKey());
        livrosMaisCaros.add(livroComPrecoMaisAlto);
      }
    }
    return livrosMaisCaros;
  }

  public List<Livro> obterLivroMaisBarato() {
    List<Livro> livrosMaisBaratos = new ArrayList<>();
    double precoMaisBaixo = Double.MAX_VALUE;

    // Outra forma, otimizando com apenas 1 for:
    if (!livrariaMap.isEmpty()) {

      for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
        Livro livro = entry.getValue();
        
        if (livro.getPreco() < precoMaisBaixo) {
            // Se encontrarmos um novo preço mais baixo, limpamos a lista e adicionamos o novo livro
            precoMaisBaixo = livro.getPreco();
            livrosMaisBaratos.clear();
            livrosMaisBaratos.add(livro);

        } else if (livro.getPreco() == precoMaisBaixo) {
            // Se encontrarmos outro livro com o mesmo preço mais baixo, adicionamos à lista
            livrosMaisBaratos.add(livro);
        }
      }
    }
    return livrosMaisBaratos;
  }

  public static void main(String[] args) {
    LivrariaOnline livrariaOnline = new LivrariaOnline();

    // Adiciona os livros à livraria online
    livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", "1984", "George Orwell", 50d);
    livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", "A Revolução dos Bichos", "George Orwell", 7.05d);
    livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", "Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d);
    livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", "Malorie", "Josh Malerman", 5d);
    livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", "E Não Sobrou Nenhum", "Agatha Christie", 50d);
    livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", "Assassinato no Expresso do Oriente", "Agatha Christie", 5d);

    // Exibe todos os livros ordenados por preço
    // System.out.println("\n Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

    //Exibe todos os livros ordenados por autor
    // System.out.println("\n Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

    // // // Pesquisa livros por autor
    // String autorPesquisa = "Agatha Christie";
    // System.out.println("\n" + livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa));

    // Obtém e exibe o livro mais caro
    // System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

    // // Obtém e exibe o livro mais barato
    // System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

    // // Remover um livro pelo título
    livrariaOnline.removerLivro("1984");
    System.out.println(livrariaOnline.livrariaMap);
    // acesso diretamente ao mapa "livrariaMap" da instância "livrariaOnline" para imprimir seu estado atual após a remoção do livro específico
  }
}
