import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Aluno: André Marques Ribeiro - RA: 25362022-2
public class Servidor {

    private String ip;
    private double ramTotal;
    private double precoPorHora;
    // Sem valor inicial, o boolean começa false: o servidor nasce desligado. RA: 25362022-2
    private boolean statusLigado;
    // Inicializada na declaração para nunca ser null (evita NullPointerException). RA: 25362022-2
    private List<Container> containers = new ArrayList<>();

    public Servidor(String ip, double ramTotal, double precoPorHora) {
        this.ip = ip;
        this.ramTotal = ramTotal;
        this.precoPorHora = precoPorHora;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public double getRamTotal() {
        return ramTotal;
    }

    public void setRamTotal(double ramTotal) {
        this.ramTotal = ramTotal;
    }

    public double getPrecoPorHora() {
        return precoPorHora;
    }

    public void setPrecoPorHora(double precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    public boolean isStatusLigado() {
        return statusLigado;
    }

    public void setStatusLigado(boolean statusLigado) {
        this.statusLigado = statusLigado;
    }

    public List<Container> getContainers() {
        return containers;
    }

    public void ligar() {
        this.statusLigado = true;
    }

    // Fail-Fast: valida tudo antes de alterar a lista. 'throws' é obrigatório
    // porque CapacidadeExcedidaException é checked. RA: 25362022-2
    public void alocarContainer(Container c) throws CapacidadeExcedidaException {
        // Validação 1 (unchecked): servidor desligado. RA: 25362022-2
        if (!statusLigado) {
            throw new ServidorOfflineException(
                    "Erro: Não é possível alocar containers em um servidor desligado.");
        }

        // Validação 2 (checked): RAM em uso + RAM do novo container não pode passar do total. RA: 25362022-2
        if (calcularRamEmUso() + c.getRamNecessaria() > ramTotal) {
            throw new CapacidadeExcedidaException(
                    "Falha Crítica: Memória RAM insuficiente no servidor " + ip + ".");
        }

        // Só adiciona depois de passar nas duas validações. RA: 25362022-2
        containers.add(c);
    }

    public double calcularRamEmUso() {
        return containers.stream()                         // fluxo de containers. RA: 25362022-2
                .mapToDouble(Container::getRamNecessaria)  // extrai só a RAM de cada um. RA: 25362022-2
                .sum();                                    // soma total (0.0 se a lista estiver vazia). RA: 25362022-2
    }

    // Identidade pelo IP, e não pelo endereço de memória. RA: 25362022-2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servidor outro = (Servidor) o;
        return Objects.equals(ip, outro.ip);
    }

    // Deve usar o mesmo campo do equals; é o que faz o HashSet barrar IP repetido. RA: 25362022-2
    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }

    @Override
    public String toString() {
        return "Servidor{ip='" + ip + "', ramTotal=" + ramTotal
                + ", precoPorHora=" + precoPorHora + ", ligado=" + statusLigado + "}";
    }
}
