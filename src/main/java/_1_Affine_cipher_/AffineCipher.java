package _1_Affine_cipher_;

import java.io.*;
import java.math.BigInteger;

public final class AffineCipher {
    private final static int m = 256;

    public static void encryptFile(final String fileName, final int a, final int b) {
        try {
            final FileInputStream fin = new FileInputStream("src\\main\\java\\_1_Affine_cipher_\\" + fileName);
            final FileOutputStream fos = new FileOutputStream("src\\main\\java\\_1_Affine_cipher_\\encrypted_" + fileName);

            final byte[] bytes = fin.readAllBytes();
            final byte[] encryptedBytes = new byte[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                encryptedBytes[i] = (byte) encryptSymbol(bytes[i], a, b);
            }
            fos.write(encryptedBytes);
            fos.flush();

            fin.close();
            fos.close();
        } catch (final FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (final IOException ignored) {
        }
    }

    public static void decryptFile(final String fileName, final int a, final int b) {
        try {
            final FileInputStream fin = new FileInputStream("src\\main\\java\\_1_Affine_cipher_\\" + fileName);
            final FileOutputStream fos = new FileOutputStream("src\\main\\java\\_1_Affine_cipher_\\decrypted_" + fileName);

            final byte[] bytes = fin.readAllBytes();
            final byte[] decryptedBytes = new byte[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                decryptedBytes[i] = (byte) decryptSymbol(bytes[i], a, b);
            }
            fos.write(decryptedBytes);
            fos.flush();

            fin.close();
            fos.close();
        } catch (final FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (final IOException ignored) {
        }
    }

    private static int encryptSymbol(final int symbol, final int a, final int b) {
        return (a * symbol + b) % m;
    }

    private static int decryptSymbol(final int symbol, final int a, final int b) {
        return ((symbol - b) * inv(a, m)) % m;
    }

    public static int inv(final int a, final int b) {
        return BigInteger.valueOf(a).modInverse(BigInteger.valueOf(b)).intValue();
    }
}
