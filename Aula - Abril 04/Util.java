public class Util {
    /**
     * método que recebe um cpf por string e retorna true se eh valido, ou false caso contrario
     * @param cpf - numero identificador da pessoa física
     * @return true se cpf valido
     */
    public static boolean cpfValido(String cpf) {
        // Remove qualquer caractere que não seja número
        cpf = cpf.replaceAll("\\D", "");

        // CPF deve ter 11 dígitos e não pode ser uma sequência de números iguais
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // Cálculo do 1º dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * (10 - i);
            }
            int digito1 = 11 - (soma % 11);
            if (digito1 > 9) digito1 = 0;

            // Cálculo do 2º dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * (11 - i);
            }
            int digito2 = 11 - (soma % 11);
            if (digito2 > 9) digito2 = 0;

            // Verifica se os dígitos calculados batem com os digitados
            return (digito1 == (cpf.charAt(9) - '0') && digito2 == (cpf.charAt(10) - '0'));

        } catch (Exception e) {
            return false;
        }
    }
}
