import java.util.Objects;

// Aluno: André Marques Ribeiro - RA: 25362022-2
public class Cliente {

    // Atributos privados: acesso só por getters/setters (encapsulamento). RA: 25362022-2
    private String cpf;
    private String nome;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Identidade pelo CPF, e não pelo endereço de memória. RA: 25362022-2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente outro = (Cliente) o;
        return Objects.equals(cpf, outro.cpf);
    }

    // Deve usar o mesmo campo do equals, senão HashMap/HashSet falham. RA: 25362022-2
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Cliente{cpf='" + cpf + "', nome='" + nome + "'}";
    }
}
