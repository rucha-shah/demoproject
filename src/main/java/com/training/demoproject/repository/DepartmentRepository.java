package com.training.demoproject.repository;

import com.training.demoproject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    @Query(value="SELECT * from department d where d.parent_department=?1",nativeQuery = true)
    List<Department> getSubDepartment(int departmentId);
}
