package com.vitor.restapi.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {
    public static String lerJsonComoString(String nomeArquivo) throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/resources/" + nomeArquivo)));
    }
}
