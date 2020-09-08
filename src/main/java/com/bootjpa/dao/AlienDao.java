package com.bootjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bootjpa.model.Alien;

//JpaRepo extends pagingandsorting which in turn extends CrudRepo
public interface AlienDao extends JpaRepository<Alien, Integer> {
	
	//Predefined JPA functions --> follow the protocols of the function naming
	List<Alien> findByTech(String tech);
	List<Alien> findByAidGreaterThan(int aid);
	
	//Userdefined functions --> the query can passed explicitly with Query annot
	//In JPA, JPQL is used 
	@Query("from Alien where tech=?1 order by aname")
	List<Alien> findByTechSorted(String tech);
}
