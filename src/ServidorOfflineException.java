// Aluno: André Marques Ribeiro - RA: 25362022-2
// Unchecked: herda de RuntimeException, o compilador não obriga try-catch. RA: 25362022-2
public class ServidorOfflineException extends RuntimeException {

    public ServidorOfflineException(String mensagem) {
        super(mensagem);
    }
}
