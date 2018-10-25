package com.dept.clients.service.api;

import com.dept.clients.dto.Client;

import java.util.List;

public interface ClientsDataService {

    void saveClientData(List<Client>  clients);

    Client enrollClient(Client client);

    Client getClientDataById(long id);

    List<Client> getAllClientsData();

    void removeClientsDataById(long id);

    Client updateClientData(Client client);

}
