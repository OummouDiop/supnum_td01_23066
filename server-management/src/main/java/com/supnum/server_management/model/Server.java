package com.supnum.server_management.model;
import jakarta.persistence.*;
@Entity
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String ip;

    private boolean status = false; // false = arrêté, true = démarré

    public Server() {}
    
    public Server(String name, String ip) {
        this.name = name;
        this.ip = ip;
        this.status = false;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}
