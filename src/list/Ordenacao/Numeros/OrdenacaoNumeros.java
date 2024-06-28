package list.Ordenacao.Numeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
  private List<Integer> numerosList;

  // NÃO precisa implementar a interface COMPARABLE porque Integer JÁ a implementa!

  public OrdenacaoNumeros() {
    numerosList = new ArrayList<>();
  }
  
  public void adicionarNumero(int numero) {
    numerosList.add(numero);
  }

  public List<Integer> ordenarAscendente() {
    List<Integer> numerosAcendentes = new ArrayList<>(numerosList);

    Collections.sort(numerosAcendentes);

    return numerosAcendentes;
  }

  public List<Integer> ordenarDescendente() {
    List<Integer> numerosDescendentes = new ArrayList<>(numerosList);

    Collections.sort(numerosDescendentes, Collections.reverseOrder()); //.sort(LISTA, COMPARATOR)
    // O método "reverseOrder" de "Collections" pode ser usado para obter um "Comparator" que impõe a ordem inversa natural

    return numerosDescendentes;
  }

  public static void main(String[] args) {
    OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

    ordenacaoNumeros.adicionarNumero(10);
    ordenacaoNumeros.adicionarNumero(15);
    ordenacaoNumeros.adicionarNumero(9);
    ordenacaoNumeros.adicionarNumero(-5);
    ordenacaoNumeros.adicionarNumero(6);

    System.out.println("\n" + ordenacaoNumeros.ordenarAscendente());
    System.out.println("\n" + ordenacaoNumeros.ordenarDescendente());
  }
}
