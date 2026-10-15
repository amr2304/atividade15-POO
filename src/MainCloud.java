import java.util.Locale;

// Aluno: André Marques Ribeiro - RA: 25362022-2
public class MainCloud {

    // 'throws' permite descomentar o Passo 6 sem try-catch e ainda compilar. RA: 25362022-2
    public static void main(String[] args) throws CapacidadeExcedidaException {

        // Passos 1 a 5: monta o cenário (o servidor nasce desligado). RA: 25362022-2
        CloudManager manager = new CloudManager();
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");
        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);
        manager.registrarCliente(cliente);
        manager.adicionarServidor(cliente, servidor);
        Container container1 = new Container("C-01", 10.0);
        Container container2 = new Container("C-02", 8.0);

        // Passo 6: falha unchecked, sem try-catch de propósito. Comentada para o programa seguir. RA: 25362022-2
        // servidor.alocarContainer(container1);

        // Passo 7: liga o servidor. RA: 25362022-2
        servidor.ligar();

        // Passo 8: aloca o Container 1 (10.0 cabe nos 16.0). RA: 25362022-2
        try {
            servidor.alocarContainer(container1);
            System.out.println("Sucesso: " + container1.getId() + " alocado no servidor "
                    + servidor.getIp() + ". RAM em uso: " + servidor.calcularRamEmUso() + " GB");
        } catch (CapacidadeExcedidaException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }

        // Passo 9: falha checked. 10.0 + 8.0 = 18.0 > 16.0, a exceção é capturada. RA: 25362022-2
        try {
            servidor.alocarContainer(container2);
            System.out.println("Sucesso: " + container2.getId() + " alocado.");
        } catch (CapacidadeExcedidaException e) {
            System.out.println("Capturado (checked): " + e.getMessage());
        }

        // Passo 10: fatura ativa. Locale.US garante o ponto decimal (5.50). RA: 25362022-2
        System.out.println("Fatura ativa de " + cliente.getNome() + ": R$ "
                + String.format(Locale.US, "%.2f", manager.calcularFaturaAtiva(cliente)));
    }
}
