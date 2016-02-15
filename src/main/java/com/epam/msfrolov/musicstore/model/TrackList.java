package com.epam.msfrolov.musicstore.model;

import java.util.Comparator;
import java.util.List;

public interface Tracklist {
    boolean add(Track file);

    void sort(Comparator<Track> comparator);

    List<Track> getList();
}
