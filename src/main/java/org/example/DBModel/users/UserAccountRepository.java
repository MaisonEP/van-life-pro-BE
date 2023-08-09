package org.example.DBModel.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<Users, java.util.UUID> {
    public List<Users>findByUsernameAndPassword(String username, String password);
    public List<Users> findByUsername(String username);


}
