package com.example.dentalapp.repository;

import com.example.dentalapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findAll();
    Employee findById(long id);
    @Query("select p from Pracownik p where p.position.name = :position")
    List<Employee> findAllDentists(String position);
}
