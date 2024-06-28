package list.Ordenacao.Pessoas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
  private List<Pessoa> pessoaList;


  public OrdenacaoPessoas() {
    pessoaList = new ArrayList<>();
  }

  public void adicionarPessoa(String nome, int idade, double altura) {
    pessoaList.add(new Pessoa(nome, idade, altura));
  }

  public List<Pessoa> ordenarPorIdade() {
    // Para usar o Comparable, Pessoa precisa implementar essa interface e Override o método
    List<Pessoa> pessoaPorIdade = new ArrayList<>(pessoaList); //Até aqui o Array está duplicado, mas a partir daí vai ordenar
    
    Collections.sort(pessoaPorIdade); //O método .sort de Collections sabe que é para usar a interface Comparable de pessoa

    return pessoaPorIdade;
  }

  public List<Pessoa> ordenarPorAltura() {
    // Para udar o Comparator é preciso de outra classe implementando-o, pois ele NÃO modifica a classe original
    List<Pessoa> pessoaPorAltura = new ArrayList<>(pessoaList); //Duplicou de novo para passar pelo sort tudo

    Collections.sort(pessoaPorAltura, new ComparatorPorAltura()); 
    //Para usar o Comparator tem que usar o .sort que passa ele INSTANCIADO

    return pessoaPorAltura;
  }

  public static void main(String[] args) {
    // Instanciando a Classe
    OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

    // Criando pessoas pelo método add
    ordenacaoPessoas.adicionarPessoa("Pessoa 1", 20, 1.67);
    ordenacaoPessoas.adicionarPessoa("Pessoa 2", 31, 1.70);
    ordenacaoPessoas.adicionarPessoa("Pessoa 3", 25, 1.59);
    ordenacaoPessoas.adicionarPessoa("Pessoa 4", 19, 1.73);
    ordenacaoPessoas.adicionarPessoa("Pessoa 5", 23, 1.67);

    System.out.println("\n" + ordenacaoPessoas.pessoaList);
    System.out.println("\n" + ordenacaoPessoas.ordenarPorIdade());
    System.out.println("\n" + ordenacaoPessoas.ordenarPorAltura());
  }
}
