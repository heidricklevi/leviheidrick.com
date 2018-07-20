package com.ljheidrick.backend;
import org.springframework.data.repository.CrudRepository;

import com.ljheidrick.backend.User;

// @bean userRepository
// crud operations
public interface UserRepository extends CrudRepository<User, Long> {
}
