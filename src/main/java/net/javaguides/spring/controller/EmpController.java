package net.javaguides.spring.controller;

import net.javaguides.spring.model.Employee;
import net.javaguides.spring.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/new/employee")
public class EmpController {

    private final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping
     public List<Employee> getAllEmp() {
        return empService.getAllEmp();
    }

    @PostMapping
    public void insertNewEmp(@RequestBody Employee employee){
        empService.insertNewEmp(employee);
    }

    @GetMapping("{id}")
    public Optional<Employee> getEmpById(@PathVariable Long id){
        return (Optional<Employee>) empService.getEmpById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        empService.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateById(@PathVariable Long id, @RequestBody Employee empDetails){
        empService.updateById(id, empDetails);
    }
}
