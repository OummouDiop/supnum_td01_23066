package com.supnum.server_management.endpoint;

import jakarta.persistence.*;

@Entity
@Table(name = "servers")
public class ServerEnpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private boolean status;
    private String ip;
    private String type;
    
    // Getters et setters
}