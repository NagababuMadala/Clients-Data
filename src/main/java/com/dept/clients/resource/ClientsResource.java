package com.dept.clients.resource;

import com.dept.clients.dto.Client;
import com.dept.clients.service.api.ClientsDataService;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients/v1/")
public class ClientsResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientsResource.class);

    private static final String CLIENTS_ENROLLMENT = "clientsdataenrollment";
    private static final String LOOKUPBYCLIENTID = "lookupbyclientid/{id}";
    private static final String LOOKUPALLCLIENTS_DATA = "lookupallclientsdata";
    private static final String REMOVE_CLIENTS_DATA = "deleteclientsdatabyid/{id}";
    private static final String UPDATE_CLIENTS_DATA = "updateclientsdata";
    private static final String SINGLE_CLIENT_ENROLLMENT = "enrollclientdata";



    @Autowired
    private ClientsDataService clientsDataService;

   @PostMapping(value = CLIENTS_ENROLLMENT)
    public ResponseEntity<?> clientDataEnrollment(@Valid @RequestBody List<Client> clients) {
       try{
           clientsDataService.saveClientData(clients);
           return new ResponseEntity<SUCCESSFUL>(HttpStatus.OK);
       }catch(Exception e){
           e.printStackTrace();
       }
       return new ResponseEntity<Error>(HttpStatus.CONFLICT);
    }

    @PostMapping(value = SINGLE_CLIENT_ENROLLMENT)
    public ResponseEntity<?> clientDataEnrollment(@RequestBody Client client) {

        try {
            clientsDataService.enrollClient(client);
            return new ResponseEntity<SUCCESSFUL>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<Error>(HttpStatus.CONFLICT);
    }

    @GetMapping(value = LOOKUPBYCLIENTID)
    public ResponseEntity<?> getclientDataById(@PathVariable("id") long id) {
        try{
            Client client=clientsDataService.getClientDataById(id);
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<Error>(HttpStatus.CONFLICT);
    }

    @GetMapping(value = LOOKUPALLCLIENTS_DATA)
    public ResponseEntity<?> getAllClientsData() {
        try{
            List<Client> clients=clientsDataService.getAllClientsData();
            return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<Error>(HttpStatus.CONFLICT);
    }

    @DeleteMapping(value = REMOVE_CLIENTS_DATA)
    public ResponseEntity<?> removeClientsDataById(@PathVariable("id") long id) {
        try{
            clientsDataService.removeClientsDataById(id);
            return new ResponseEntity<SUCCESSFUL>(HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<Error>(HttpStatus.CONFLICT);
    }

    @PutMapping(value = UPDATE_CLIENTS_DATA)
    public ResponseEntity<?> updateClientsData(@Valid @RequestBody Client client) {
        try{
            clientsDataService.updateClientData(client);
            return new ResponseEntity<SUCCESSFUL>(HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<Error>(HttpStatus.CONFLICT);
    }

}
