package com.training.demoproject.repository;

import com.training.demoproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value="SELECT COUNT(e.employee_id) from employee e JOIN department d on e.department_id = d.department_id where d.parent_department=?1",nativeQuery = true)
    int getCountOfEmployee(int departmentId);

    @Query(value="SELECT AVG(salary) from employee e group by e.department_id",nativeQuery = true)
    List<Double> getAverageSalary();

}
