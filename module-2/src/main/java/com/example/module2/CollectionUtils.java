package com.example.module2;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Utility class for collection operations using Guava.
 */
public class CollectionUtils {

    /**
     * Creates an immutable list from the given elements.
     */
    @SafeVarargs
    public static <T> List<T> immutableListOf(T... elements) {
        return ImmutableList.copyOf(elements);
    }

    /**
     * Partitions a list into sublists of the specified size.
     */
    public static <T> List<List<T>> partition(List<T> list, int size) {
        return Lists.partition(list, size);
    }

    /**
     * Reverses a list and returns a new list.
     */
    public static <T> List<T> reverse(List<T> list) {
        return Lists.reverse(list);
    }
}
