package com.supnum.server_management.service;


import com.supnum.server_management.model.Server;
import java.util.List;
public abstract class ServerService {
    public abstract Server createServer(Server server);

    public abstract List<Server> listServers();

    public abstract Server renameServer(Long id, String newName);

    public abstract boolean getStatus(Long id);

    public abstract Server startServer(Long id);

    public abstract Server stopServer(Long id);

    public abstract void deleteServer(Long id);
}
