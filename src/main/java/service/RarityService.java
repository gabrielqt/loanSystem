package service;

import dao.RarityDaoJDBC;
import model.Rarity;


public class RarityService extends GenericService<Rarity> {
    public RarityService() {
        super(RarityDaoJDBC::new);
    }
}
