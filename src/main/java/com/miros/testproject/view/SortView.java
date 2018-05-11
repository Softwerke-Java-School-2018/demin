package com.miros.testproject.view;

import java.util.stream.Stream;


/**
 * Interface for all SortView classes
 */
public interface SortView {
     <T> void sort(Stream<T> stream);
}
