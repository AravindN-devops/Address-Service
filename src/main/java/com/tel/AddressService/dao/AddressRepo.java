package com.tel.AddressService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tel.AddressService.entity.Address;
import java.util.List;


@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

	@Query(nativeQuery = true,value = "select a.id,a.street,a.city,a.pincode from address a join employee e on a.employee_id = e.id where a.employee_id=:employeeid")
	Address findAddressByEmployeeId(@Param("employeeid") int id);
	
	Address findByEmployeeId(int employeeId);
	
}
