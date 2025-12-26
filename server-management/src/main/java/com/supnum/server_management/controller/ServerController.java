package com.supnum.server_management.controller;

import com.supnum.server_management.model.Server;
import com.supnum.server_management.service.ServerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servers")
public class ServerController {

    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    // Créer un serveur
    @PostMapping
    public ResponseEntity<Server> createServer(@RequestBody Server server) {
        Server created = serverService.createServer(server);
        return ResponseEntity.ok(created);
    }

    // Lister tous les serveurs
    @GetMapping
    public ResponseEntity<List<Server>> listServers() {
        return ResponseEntity.ok(serverService.listServers());
    }

    // Renommer un serveur
    @PutMapping("/{id}/rename")
    public ResponseEntity<Server> renameServer(@PathVariable Long id, @RequestParam String name) {
        return ResponseEntity.ok(serverService.renameServer(id, name));
    }

    // Récupérer le statut d'un serveur
    @GetMapping("/{id}/status")
    public ResponseEntity<Boolean> getStatus(@PathVariable Long id) {
        return ResponseEntity.ok(serverService.getStatus(id));
    }

    // Démarrer un serveur
    @PostMapping("/{id}/start")
    public ResponseEntity<Server> startServer(@PathVariable Long id) {
        return ResponseEntity.ok(serverService.startServer(id));
    }

    // Arrêter un serveur
    @PostMapping("/{id}/stop")
    public ResponseEntity<Server> stopServer(@PathVariable Long id) {
        return ResponseEntity.ok(serverService.stopServer(id));
    }

    // Supprimer un serveur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServer(@PathVariable Long id) {
        serverService.deleteServer(id);
        return ResponseEntity.noContent().build();
    }
}
