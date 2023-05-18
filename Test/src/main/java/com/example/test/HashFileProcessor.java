package com.example.test;

        import org.apache.commons.codec.digest.DigestUtils;

        import javax.annotation.PostConstruct;
        import javax.annotation.PreDestroy;
        import java.io.File;
        import java.io.IOException;
        import java.nio.charset.StandardCharsets;
        import java.nio.file.Files;

public class HashFileProcessor {

    private final String inputFile;
    private final String outputFile;

    public HashFileProcessor(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @PostConstruct
    public void hashInputFile() throws IOException {
        File input = new File(inputFile);
        File output = new File(outputFile);

        if (!input.exists()) {
            Files.writeString(output.toPath(), "null", StandardCharsets.UTF_8);
        } else {
            String hash = DigestUtils.sha256Hex(Files.readString(input.toPath()));
            Files.writeString(output.toPath(), hash, StandardCharsets.UTF_8);
        }
    }

    @PreDestroy
    public void deleteInputFile() throws IOException {
        File input = new File(inputFile);
        if (input.exists()) {
            Files.delete(input.toPath());
        }
    }
}