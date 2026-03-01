package service;

import dao.LoanDaoJDBC;
import model.Loan;

import java.util.Optional;

//        |rarity_ds|minimal_reputation_points|
//        |---------|-------------------------|
//        |Common   |0.000                    |
//        |Uncommon |75.000                   |
//        |Rare     |150.000                  |
//        |Epic     |225.000                  |
//        |Legendary|300.000                  |
//        |Mythic   |375.000                  |



public class LoanService extends GenericService<Loan>{
    public LoanService() {
        super(LoanDaoJDBC::new);
    }

    public Optional<Loan> createLoan(Loan loan){
        if(!(loan.getItem().isAvailable())){
            return Optional.empty();
        }

        switch (loan.getItem().getRarity().getRarity_ds()) {
            case "Common":
                break;
            case "Uncommon":
                break;
            case "Rare":
                break;
            case "Epic":
                break;
            case "Legendary":
                break;
            case "Mythic":
                break;
        }

        return Optional.empty();
    }
}

