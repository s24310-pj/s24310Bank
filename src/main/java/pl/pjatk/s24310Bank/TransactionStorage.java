package pl.pjatk.s24310Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionStorage {

    Transaction t1 = new Transaction(new Client(1, 1000), Status.ACCEPTED, 20);
    Transaction t2 = new Transaction(new Client(2, 25000), Status.ACCEPTED, 2000);


    List<Transaction> transactionList = new ArrayList<>();

    public List<Transaction> getTransactionList() {
        return transactionList;
    }


    public TransactionStorage() {
        transactionList.add(t1);
        transactionList.add(t2);
    }


}


