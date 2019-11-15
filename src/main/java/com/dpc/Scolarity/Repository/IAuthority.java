
package com.dpc.Scolarity.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dpc.Scolarity.Domain.Authority;






public interface IAuthority extends JpaRepository<Authority, Long>{

	@Query("SELECT p FROM Authority p WHERE p.name = :name")
    public Authority findByname(@Param("name") String name );
	public Authority findByDescription(String  role );


}
