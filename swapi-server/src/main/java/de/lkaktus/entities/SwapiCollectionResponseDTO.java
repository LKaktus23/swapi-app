package de.lkaktus.entities;

import java.util.List;

public record SwapiCollectionResponseDTO<T>(
        int count,
        String next,
        String previous,
        List<T> results
) {
}
