package _2_Transposition_cipher_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Encrypt {
    public static void main(final String[] args) {
        final Reader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            System.out.println("Введите название файла для зашифровки");
            TranspositionCipher.encryptFile(bufferedReader.readLine(), new Integer[]{3, 5, 1, 6, 2, 4});
        } catch (final IOException ignored) {
        }
    }

}
