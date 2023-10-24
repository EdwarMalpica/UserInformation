package online.grupo3devops.userinfo.repo;

import online.grupo3devops.userinfo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
