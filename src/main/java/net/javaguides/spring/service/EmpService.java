package net.javaguides.spring.service;


import net.javaguides.spring.exception.ResourceNotFoundException;
import net.javaguides.spring.model.Employee;
import net.javaguides.spring.repository.EmpRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    private final EmpRepository empRepository;

    public EmpService(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    public List<Employee> getAllEmp() {
        return empRepository.findAll();
    }

    public void insertNewEmp(Employee employee) {
        List<Employee> employee1= empRepository
                .findByFirstNameAndLastNameAndAge(employee.getFirstName(), employee.getLastName(), employee.getAge());
        if (!employee1.isEmpty()){
            throw new ResourceNotFoundException("Entry already exists");
        }
        empRepository.save(employee);
    }

    public Optional<Employee> getEmpById(Long id) {
        return (Optional<Employee>) empRepository.findById(id);
    }

    public void deleteById(Long id) {
        Employee employee=empRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("employee with id:"+id+" does not exist"));
        empRepository.deleteById(id);
    }

    public void updateById(Long id, Employee empDetails) {
        Employee updatedEmp=empRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("employee with id:"+id+" does not exist"));
        updatedEmp.setFirstName(empDetails.getFirstName());
        updatedEmp.setLastName(empDetails.getLastName());
        updatedEmp.setAge(empDetails.getAge());


        List<Employee> employeeCheck=empRepository
                .findByFirstNameAndLastNameAndAge(updatedEmp.getFirstName(), updatedEmp.getLastName(), updatedEmp.getAge());
        if (!employeeCheck.isEmpty()){
            throw new ResourceNotFoundException("Entry already exists");
        }
        empRepository.save(updatedEmp);

    }
}
