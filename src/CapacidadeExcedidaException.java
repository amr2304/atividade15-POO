// Aluno: André Marques Ribeiro - RA: 25362022-2
// Checked: herda de Exception, o compilador obriga try-catch ou throws. RA: 25362022-2
public class CapacidadeExcedidaException extends Exception {

    public CapacidadeExcedidaException(String mensagem) {
        super(mensagem);
    }
}
