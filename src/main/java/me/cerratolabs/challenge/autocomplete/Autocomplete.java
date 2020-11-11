package me.cerratolabs.challenge.autocomplete;

import java.io.File;
import java.util.List;

public interface Autocomplete {

    List<String> matches(String prefix);
}
