package map.Ordenacao.Eventos;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
  private Map<LocalDate, Evento> agendaMap;

  public AgendaEventos() {
    this.agendaMap = new HashMap<>();
  }

  public void adicionarEvento(LocalDate data, String nome, String atracao) {
    agendaMap.put(data, new Evento(nome, atracao));
  }

  public void exibirAgenda() {
    // Usando o TreeMap para dar ordenação
    // O LocalDate extende a Comparable, então ele já sabe organizar as datas
    Map<LocalDate, Evento> agendaTreeMap = new TreeMap<>(agendaMap);
    System.out.println(agendaTreeMap);
  }

  public void obterProximoEvento() {
    // Pegando a data atual:
    LocalDate dataAtual = LocalDate.now();
    // Passando e ordenando o Map:
    Map<LocalDate, Evento> agendaTreeMap = new TreeMap<>(agendaMap);

    for (Map.Entry<LocalDate, Evento> entry : agendaTreeMap.entrySet()) {
      if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
        System.out.println("Próximo evento: " + entry.getValue() + " na data: " + entry.getKey());
        break;
      }
    }
  }

  public static void main(String[] args) {
    AgendaEventos agendaEventos = new AgendaEventos();

    agendaEventos.adicionarEvento(LocalDate.of(2023, 3, 30), "Aniversário", "Soberanas do Samba");
    agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JULY, 7), "Quintal do Patrão", "Soberanas do Samba");
    agendaEventos.adicionarEvento(LocalDate.of(2024, 7, 9), "Casarão", "Soberanas do Samba");
    agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 7), "Belo Horizonte", "Bethânia e Caetano");

    agendaEventos.exibirAgenda();
    agendaEventos.obterProximoEvento();
  }
}