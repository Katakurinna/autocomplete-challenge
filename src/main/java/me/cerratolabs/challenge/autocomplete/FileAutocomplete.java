package me.cerratolabs.challenge.autocomplete;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileAutocomplete implements Autocomplete {
    private String file;
    private String prefix;
    public FileAutocomplete (String file) {
        this.file = file;
    }

    public List<String> matches(String prefix) {
        this.prefix = prefix;
        try {
            List<String> list = Files.readAllLines( Paths.get(file));
            return list.stream().filter(this::containsPrefix).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean containsPrefix(String word) {
        return word.contains(prefix);
    }
}
