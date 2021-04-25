package challenge;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * seguindo a sugestão do DAN - TURMA 7, utilizei o seguinte site como base:
 * https://stackoverflow.com/questions/13630346/how-do-i-add-an-integer-to-a-char-in-java#:~:text=In%20Java%2C%20char%20and%20int,to%20your%20character%20varaible%20back
 */
public class CriptografiaCesariana implements Criptografia {

    int KEY_ENCRYPTION = 3;
    int KEY_DECRYPTION = -3;

    public String processing(String message, int key) {
        this.verifyExistExceptions(message);

        return String.join("", Arrays.stream(message.split(""))
                .map(String::toLowerCase)
                .map((letter) -> {
                    if(!letter.equals(" ") && !Character.isDigit(letter.charAt(0))){
                        return String.valueOf((char) (letter.charAt(0) + key));
                    }else{
                        return letter;
                    }
                }).toArray(String[]::new));
    }

    public void verifyExistExceptions(String text) {
        if (text.isEmpty()) throw new IllegalArgumentException("O texto está vazio, impossível criptografar");
        if (text == null) throw new NullPointerException("não é um texto!");
    }

    @Override
    public String criptografar(String texto) {
        return processing(texto, KEY_ENCRYPTION);
    }

    @Override
    public String descriptografar(String texto) {
        return processing(texto, KEY_DECRYPTION);
    }
}
