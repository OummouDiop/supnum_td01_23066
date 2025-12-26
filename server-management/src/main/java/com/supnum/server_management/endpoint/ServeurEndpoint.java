package com.supnum.server_management.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.supnum.server_management.generated.GetServeurRequest;
import com.supnum.server_management.generated.GetServeurResponse;
import com.supnum.server_management.generated.Serveur;
import com.supnum.server_management.service.ServerService;
import com.supnum.server_management.model.Server;
import org.springframework.beans.factory.annotation.Autowired;

@Endpoint
public class ServeurEndpoint {
    private static final String NAMESPACE_URI = "http://supnum.com/serveur";

    private final ServerService serverService;

    @Autowired
    public ServeurEndpoint(ServerService serverService) {
        this.serverService = serverService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetServeurRequest")
    @ResponsePayload
    public GetServeurResponse getServeur(@RequestPayload GetServeurRequest request) {
        GetServeurResponse response = new GetServeurResponse();
        Server server = serverService.listServers().stream()
                .filter(s -> s.getId().equals(request.getId()))
                .findFirst()
                .orElse(null);
        if (server != null) {
            Serveur soapServeur = new Serveur();
            soapServeur.setId(server.getId());
            soapServeur.setNom(server.getName());
            soapServeur.setStatut(server.isStatus());
            soapServeur.setIp(server.getIp());
            // Le champ 'type' n'existe pas dans Server, on laisse vide ou on met une valeur par défaut
            soapServeur.setType("");
            response.setServeur(soapServeur);
        }
        return response;
    }
}