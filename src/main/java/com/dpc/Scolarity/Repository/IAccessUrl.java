package com.dpc.Scolarity.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dpc.Scolarity.Domain.AccessUrl;
import com.dpc.Scolarity.Domain.Authority;
import com.dpc.Scolarity.Domain.GestionUrl;



public interface IAccessUrl extends JpaRepository<AccessUrl, Long> {

	@Query("SELECT p FROM AccessUrl p WHERE p.authority = :authority ")
    public List<AccessUrl> findbyauthority(@Param("authority") Authority authority);
	public AccessUrl findByauthorityAndGestionUrl(Authority role , GestionUrl gestion);
}
