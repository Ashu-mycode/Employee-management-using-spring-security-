/*
 * Repository of Employee which inherited by JpaRepo it is Contain many method which is built-in java 
 * */

package com.example.Employeeemanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Employeeemanagement.entity.Employees;


@Repository
public interface IEmployeeRepository extends JpaRepository<Employees,Long> {
	
	/*@Query("update Employees e set e.status=Active where e.id=?1")
	@Modifying
	@Transactional
	 void deleteByIdAndStatus(long id, String status);*/

}
