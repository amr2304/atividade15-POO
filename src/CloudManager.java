import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Aluno: André Marques Ribeiro - RA: 25362022-2
public class CloudManager {

    // HashMap (baseado em Hash). Chave: Cliente. Valor: Set de Servidores (sem duplicados, sem ordem). RA: 25362022-2
    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    // putIfAbsent só cria o conjunto se o cliente ainda não existir, sem apagar servidores já associados. RA: 25362022-2
    public void registrarCliente(Cliente cliente) {
        bancoDeDados.putIfAbsent(cliente, new HashSet<>());
    }

    // O cliente precisa estar registrado; o Set ignora IP repetido. RA: 25362022-2
    public void adicionarServidor(Cliente cliente, Servidor servidor) {
        bancoDeDados.get(cliente).add(servidor);
    }

    public double calcularFaturaAtiva(Cliente c) {
        return bancoDeDados.getOrDefault(c, Set.of())   // conjunto vazio se o cliente não existir (evita null). RA: 25362022-2
                .stream()
                .filter(Servidor::isStatusLigado)        // só servidores ligados. RA: 25362022-2
                .mapToDouble(Servidor::getPrecoPorHora)  // extrai o preço por hora. RA: 25362022-2
                .sum();
    }
}
