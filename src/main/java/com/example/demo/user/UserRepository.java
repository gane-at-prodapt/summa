package com.example.demo.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
//	@Query("SELECT u FROM User u, Auth a WHERE u.id = a.id AND a.token=:token")
//    List<User> findByGenre(@Param("token") String token);

}
