package ru.innopolis.java.tvapp.repository;

import ru.innopolis.java.tvapp.model.TV;

import java.util.List;

public interface TVDao {
    TV createTV(TV tv);
    TV updateTV(TV tv);
    void deleteTV(Long id);
    TV getTVById(Long id);
    List<TV> getAllTVs();
}