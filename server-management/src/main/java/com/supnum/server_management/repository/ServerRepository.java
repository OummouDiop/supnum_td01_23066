package com.supnum.server_management.repository;

import com.supnum.server_management.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Long> {
    
}