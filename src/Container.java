import java.util.Objects;

// Aluno: André Marques Ribeiro - RA: 25362022-2
public class Container {

    // Atributos privados (encapsulamento). RA: 25362022-2
    private String id;
    private double ramNecessaria;

    public Container(String id, double ramNecessaria) {
        this.id = id;
        this.ramNecessaria = ramNecessaria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRamNecessaria() {
        return ramNecessaria;
    }

    public void setRamNecessaria(double ramNecessaria) {
        this.ramNecessaria = ramNecessaria;
    }

    // Identidade pelo ID, e não pelo endereço de memória. RA: 25362022-2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container outro = (Container) o;
        return Objects.equals(id, outro.id);
    }

    // Deve usar o mesmo campo do equals. RA: 25362022-2
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Container{id='" + id + "', ramNecessaria=" + ramNecessaria + "}";
    }
}
