package map.OperacoesBasicas.Agenda;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
  private Map<String, Integer> agendaMap;

  public AgendaContatos() {
    this.agendaMap = new HashMap<>();
  }

  public void adicionarContato(String nome, Integer telefone) {
    agendaMap.put(nome, telefone);
  }

  public void removerContato(String nome) {
    if (!agendaMap.isEmpty()) {
      agendaMap.remove(nome);
    }
  }

  public void exibirContatos() {
    System.out.println(agendaMap);
  }

  public Integer pesquisarPorNome(String nome) {
    // Criando variável para armazenar o retorno no método .get
    Integer numeroPorNome = null;

    if (!agendaMap.isEmpty()) {
      numeroPorNome = agendaMap.get(nome);
    }

    return numeroPorNome;
  }

  public static void main(String[] args) {
    AgendaContatos agendaContatos = new AgendaContatos();

    agendaContatos.adicionarContato("Natalia", 1699558877);
    agendaContatos.adicionarContato("Natalia", 97225586); 
    //O método .put adiciona e subescreve/atualiza o valor da chave!
    agendaContatos.adicionarContato("Natalia Brunelli", 1955883321);
    agendaContatos.adicionarContato("Fernanda", 1941365502);

    System.out.println("O número do contato é: " + agendaContatos.pesquisarPorNome("Fernanda"));
    agendaContatos.removerContato("Natalia Brunelli");
    agendaContatos.exibirContatos();
  }
}
