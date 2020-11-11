package me.cerratolabs.challenge.autocomplete;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Data
public class Autocomplete {
    private String prefix;
    private List<String> list;

    public Autocomplete(String file) throws IOException {
        setList(Files.readAllLines(Paths.get(file)));
    }

    public Autocomplete(List<String> list) {
        setList(list);
    }

    public List<String> matches(@NotNull String prefix) {
        if (isNull(prefix)) return null;
        this.prefix = prefix;
        return list.stream().filter(this::containsPrefix).collect(Collectors.toList());
    }

    private boolean containsPrefix(String word) {
        return word.startsWith(prefix);
    }
}
