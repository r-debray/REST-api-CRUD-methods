package net.javaguides.spring.repository;

import net.javaguides.spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> {

//    all crud operations
//    @Query(value = "SELECT e FROM Employee e WHERE e.fistName=? AND e.lastName=? AND e.age=?", nativeQuery=true)
    List<Employee> findByFirstNameAndLastNameAndAge(String firstName, String lastName, Long age);
}

