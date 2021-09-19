package _1_Affine_cipher_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public final class Encrypt {
    public static void main(final String[] args) {
        final Reader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            System.out.println("Введите название файла для зашифровки");
            AffineCipher.encryptFile(bufferedReader.readLine(),19, 56);
        } catch (final IOException ignored) {
        }
    }
}
