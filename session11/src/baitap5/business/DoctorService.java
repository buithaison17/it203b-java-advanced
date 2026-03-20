package baitap5.business;

import baitap5.dao.DoctorRepository;
import baitap5.interfaces.IRepository;
import baitap5.model.Doctor;

import java.util.List;
import java.util.Map;

public class DoctorService implements IRepository {
    private final DoctorRepository doctorRepository = new DoctorRepository();

    @Override
    public boolean add(String name, String specialty) {
        return doctorRepository.add(name, specialty);
    }

    @Override
    public Map<String, Integer> countBySpecialty() {
        return doctorRepository.countBySpecialty();
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
