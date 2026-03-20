package baitap5.interfaces;

import baitap5.model.Doctor;

import java.util.List;
import java.util.Map;

public interface IRepository {
    boolean add(String name, String specialty);

    Map<String, Integer> countBySpecialty();

    List<Doctor> findAll();
}
