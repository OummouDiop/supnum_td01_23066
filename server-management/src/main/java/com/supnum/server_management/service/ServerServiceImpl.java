package com.supnum.server_management.service;
import com.supnum.server_management.model.Server;
import com.supnum.server_management.repository.ServerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServerServiceImpl implements ServerService {

    private final ServerRepository serverRepository;

    public ServerServiceImpl(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    @Override
    public Server createServer(Server server) {
        server.setStatus(false);
        return serverRepository.save(server);
    }
    @Override
    public List<Server> listServers() {
        return serverRepository.findAll();
    }

    @Override
    public Server renameServer(Long id, String newName) {
        Server server = serverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Server not found"));
        server.setName(newName);
        return serverRepository.save(server);
    }
    @Override
    public boolean getStatus(Long id) {
        return serverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Server not found"))
                .isStatus();
    }

    @Override
    public Server startServer(Long id) {
        Server server = serverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Server not found"));
        server.setStatus(true);
        return serverRepository.save(server);
    }
    @Override
    public Server stopServer(Long id) {
        Server server = serverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Server not found"));
        server.setStatus(false);
        return serverRepository.save(server);
    }

    @Override
    public void deleteServer(Long id) {
        Server server = serverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Server not found"));
        if (server.isStatus()) {
            throw new IllegalStateException("Cannot delete a running server");
        }
        serverRepository.delete(server);
    }

}
}