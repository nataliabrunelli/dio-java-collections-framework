package list.Pesquisa.SomaDeNumeros;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
  private List<Integer> somaList = new ArrayList<>();


  public SomaNumeros() {
    somaList = new ArrayList<>();
  }

  public void adicionarNumero(int numero) {
    somaList.add(numero);
  }

  public int calcularSoma() {
    int soma = 0;

    if (!somaList.isEmpty()) {
      for (Integer n : somaList) {
        soma += n;
      }
    }

    return soma;
  }

  public int encontrarMaiorNumero() {
    int maior = 0;
    
    if (!somaList.isEmpty()) {
      for (Integer m : somaList) {
        if (maior < m) {
          maior = m;
        }
      }
    }

    return maior;
  }

  public int encontrarMenorNumero() {
    int menor = somaList.get(0);
    
    if (!somaList.isEmpty()) {
      for (Integer m : somaList) {
        if (menor > m) {
          menor = m;
        }
      }
    }

    return menor;
  }

  public void exibirNumeros() {
    System.out.println(somaList);
  }

  public static void main(String[] args) {
    SomaNumeros somaNumeros = new SomaNumeros();

    somaNumeros.adicionarNumero(5);
    somaNumeros.adicionarNumero(7);
    somaNumeros.adicionarNumero(9);
    somaNumeros.adicionarNumero(11);
    somaNumeros.adicionarNumero(13);
    somaNumeros.adicionarNumero(4);

    System.out.println(somaNumeros.calcularSoma());
    System.out.println(somaNumeros.encontrarMaiorNumero());
    System.out.println(somaNumeros.encontrarMenorNumero());
    somaNumeros.exibirNumeros();
  }
}
