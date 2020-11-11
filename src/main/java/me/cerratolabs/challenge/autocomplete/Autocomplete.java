package me.cerratolabs.challenge.autocomplete;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

/**
 * @author Alejandro Cerrato (@Katakurinna)
 * <p>
 * He decidido usar lambdas y métodos existentes porque en Java actualmente,
 * en las entrevistas de trabajo, se busca a alguien que sepa trabajar con
 * strings y lambdas sin problemas.
 *
 * Y porque limitar el potencial de un lenguaje de programación,
 * haciendo código nativo, no tiene sentido.
 * Es como comprarte un coche y no arrancar el motor.
 *
 * Puedes probarlo con los Tests que tengo hecho.
 */
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

    /**
     * Get prefix matches from list of strings
     * @param prefix
     * @return list of matches
     */
    public List<String> matches(@NotNull String prefix) {
        if (isNull(prefix)) return null;
        this.prefix = prefix;
        return list.stream().filter(this::containsPrefix).collect(Collectors.toList());
    }

    private boolean containsPrefix(String word) {
        return word.startsWith(prefix);
    }
}
