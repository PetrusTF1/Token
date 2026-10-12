package br.com.petrusspring.spring_security_jwt;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;

public class KeyGenerator {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();

        Base64.Encoder encoder = Base64.getMimeEncoder(64, "\n".getBytes());

        String privateKeyPem = "-----BEGIN PRIVATE KEY-----\n"
                + encoder.encodeToString(pair.getPrivate().getEncoded())
                + "\n-----END PRIVATE KEY-----\n";

        String publicKeyPem = "-----BEGIN PUBLIC KEY-----\n"
                + encoder.encodeToString(pair.getPublic().getEncoded())
                + "\n-----END PUBLIC KEY-----\n";

        Path resourcesDir = Paths.get("src/main/resources");
        Files.writeString(resourcesDir.resolve("app.key"), privateKeyPem);
        Files.writeString(resourcesDir.resolve("app.pub"), publicKeyPem);

        System.out.println("Chaves geradas com sucesso em src/main/resources!");
    }
}
