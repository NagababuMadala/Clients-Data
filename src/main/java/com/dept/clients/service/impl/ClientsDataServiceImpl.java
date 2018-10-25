package com.dept.clients.service.impl;

import com.dept.clients.dto.Client;
import com.dept.clients.repository.ClientRepository;
import com.dept.clients.service.api.ClientsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ClientsDataService")
public class ClientsDataServiceImpl implements ClientsDataService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    @Transactional
    public void  saveClientData(List<Client> clients) {
        clientRepository.save(clients);
    }

    @Override
    @Transactional
    public Client getClientDataById(long id){

      return  clientRepository.findOne(id);
    }

    @Override
    @Transactional
    public List<Client> getAllClientsData(){
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public void removeClientsDataById(long id){
        clientRepository.delete(id);
    }

    @Override
    @Transactional
    public Client updateClientData(Client client){
        return clientRepository.save(client);
    }

   @Override
    @Transactional
    public Client enrollClient(Client client){

    return clientRepository.save(client);
    }

}
