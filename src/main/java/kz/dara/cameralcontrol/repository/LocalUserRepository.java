package kz.dara.cameralcontrol.repository;

import kz.dara.cameralcontrol.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface LocalUserRepository extends JpaRepository<User, Long> {

//  @Query(value = "select * from users " +
//          " where (lower(surname) || lower(name) || lower(middle_name)) ilike :search " +
//          " and iin <> :iin", nativeQuery = true)
//  Page<User> findAllBySearchFio(String search, String iin, Pageable pageable);

  List<User> findAllByIdIn(List<Long> ids);
  User findUserByUsername(String username);
}
