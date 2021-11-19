package _2_Transposition_cipher_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class TranspositionCipher {
    public static void encryptFile(final String fileName, final Integer[] arr) {
        try {
            final FileInputStream fin = new FileInputStream("src\\main\\java\\_2_Transposition_cipher_\\" + fileName);
            final FileOutputStream fos = new FileOutputStream("src\\main\\java\\_2_Transposition_cipher_\\encrypted_" + fileName);

            final byte[] bytes = fin.readAllBytes();
            final byte[] encryptedBytes = new byte[bytes.length];
            for (int i = 0; i < bytes.length / 6; i++) {
                byte[] bytesBlock = new byte[]{
                        bytes[i * 6], bytes[i * 6 + 1],
                        bytes[i * 6 + 2], bytes[i * 6 + 3],
                        bytes[i * 6 + 4], bytes[i * 6 + 5]
                };
                byte[] encryptedBlock = encryptBlock(bytesBlock, arr);
                System.arraycopy(encryptedBlock, 0, encryptedBytes, i * 6, 6);
            }
            if (bytes.length - (bytes.length / 6) * 6 >= 0)
                System.arraycopy(bytes, (bytes.length / 6) * 6, encryptedBytes, (bytes.length / 6) * 6, bytes.length - (bytes.length / 6) * 6);

            fos.write(encryptedBytes);
            fos.flush();

            fin.close();
            fos.close();
        } catch (final FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (final IOException ignored) {
        }
    }

    public static void decryptFile(final String fileName, final Integer[] arr) {
        try {
            final FileInputStream fin = new FileInputStream("src\\main\\java\\_2_Transposition_cipher_\\" + fileName);
            final FileOutputStream fos = new FileOutputStream("src\\main\\java\\_2_Transposition_cipher_\\decrypted_" + fileName);

            final byte[] bytes = fin.readAllBytes();
            final byte[] decryptedBytes = new byte[bytes.length];
            for (int i = 0; i < bytes.length / 6; i++) {
                byte[] bytesBlock = new byte[]{
                        bytes[i * 6], bytes[i * 6 + 1],
                        bytes[i * 6 + 2], bytes[i * 6 + 3],
                        bytes[i * 6 + 4], bytes[i * 6 + 5]
                };
                byte[] decryptedBlock = decryptBlock(bytesBlock, arr);
                System.arraycopy(decryptedBlock, 0, decryptedBytes, i * 6, 6);
            }
            if (bytes.length - (bytes.length / 6) * 6 >= 0)
                System.arraycopy(bytes, (bytes.length / 6) * 6, decryptedBytes, (bytes.length / 6) * 6, bytes.length - (bytes.length / 6) * 6);

            fos.write(decryptedBytes);
            fos.flush();

            fin.close();
            fos.close();
        } catch (final FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (final IOException ignored) {
        }
    }

    public static byte[] encryptBlock(final byte[] bytesBlock, final Integer[] arr) {
        byte[] encryptedBytesBlock = new byte[bytesBlock.length];
        for (int i = 0; i < bytesBlock.length; i++) {
            encryptedBytesBlock[i] = bytesBlock[arr[i] - 1];
        }
        return encryptedBytesBlock;
    }

    public static byte[] decryptBlock(final byte[] bytesBlock, final Integer[] arr) {
        byte[] decryptedBytesBlock = new byte[bytesBlock.length];
        for (int i = 0; i < bytesBlock.length; i++) {
            decryptedBytesBlock[i] = bytesBlock[Arrays.asList(arr).indexOf(i + 1)];
        }
        return decryptedBytesBlock;
    }
}
//encrypted_text.txt