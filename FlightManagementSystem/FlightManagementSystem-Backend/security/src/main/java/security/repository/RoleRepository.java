package security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import security.pojo.ERole;
import security.pojo.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Optional<Role> findByName(ERole name);

}
