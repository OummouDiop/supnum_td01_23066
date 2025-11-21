package com.supnum.server_management.service;


import com.supnum.server_management.model.Server;
import java.util.List;
public class ServerService {
    Server createServer(Server server);

    List<Server> listServers();

    Server renameServer(Long id, String newName);

    boolean getStatus(Long id);

    Server startServer(Long id);

    Server stopServer(Long id);

    void deleteServer(Long id);
}
