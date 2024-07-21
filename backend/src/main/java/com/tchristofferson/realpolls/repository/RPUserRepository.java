package com.tchristofferson.realpolls.repository;

import com.tchristofferson.realpolls.model.RPUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RPUserRepository extends JpaRepository<RPUser, Long> {

    Optional<RPUser> findByEmail(String email);

}
