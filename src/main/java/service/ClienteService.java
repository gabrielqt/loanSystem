package service;

import dao.ClientDaoJDBC;
import model.Client;

public class ClienteService extends GenericService<Client>{
    public ClienteService(){
        super(ClientDaoJDBC::new);
    }
}
