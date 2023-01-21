package pl.pjatk.s24310Bank;

import org.springframework.stereotype.Component;

@Component
public class BankService {

    private final TransactionStorage transactionStorage;
    private final ClientStorage clientStorage;


    public BankService(TransactionStorage transactionStorage, ClientStorage clientStorage) {
        this.transactionStorage = transactionStorage;
        this.clientStorage = clientStorage;
    }

    public Client registration(int id, double balance) {
        if (balance > 0) {
            System.out.println("Klient o id: " + id + " zostal zarejestrowany, aktualny stan konta to: " + balance);
            clientStorage.getClientList().add(new Client(id, balance));
            return (new Client(id, balance));
        }
        System.out.println("Nie mozna zarejestrowac klienta ze wzgledu na zbyt may stan konta");
        return null;
    }

    public Transaction cashTransferOrder(int id, double amount) {
        if (clientStorage.getClientById(id) != null) {
            if (clientStorage.getClientBalance(id) > amount) {
                transactionStorage.transactionList.add(new Transaction(clientStorage.getClientById(id), Status.ACCEPTED, amount));
                clientStorage.getClientById(id).setBalance(clientStorage.getClientBalance(id) - amount);
                System.out.println("Przelew wykonany, nowe saldo: " + getClientBalance(id));
                return new Transaction(clientStorage.getClientById(id), Status.ACCEPTED, amount);
            } else {
                transactionStorage.transactionList.add(new Transaction(clientStorage.getClientById(id), Status.DECLINED, amount));
                System.out.println("Nie udalo sie wykonac przelewu, za malo srodkow na koncie");
                return new Transaction(clientStorage.getClientById(id), Status.DECLINED, amount);
            }
        } else {
            return null;
        }
    }

    public Transaction cashPayment(int id, double amount) {
        if (clientStorage.getClientById(id) != null) {
            transactionStorage.transactionList.add(new Transaction(clientStorage.getClientById(id), Status.ACCEPTED, amount));
            clientStorage.getClientById(id).setBalance(clientStorage.getClientBalance(id) + amount);
            System.out.println("Udalo sie wplacic gotowke, nowy stan konta klienta o id: " + id + " to: " + (clientStorage.getClientBalance(id) + amount));
            return new Transaction(clientStorage.getClientById(id), Status.ACCEPTED, amount);
        } else {
            System.out.println("Nie mozna wplacic gotowki, klient nie jest zarejestrowany");
            return null;
        }
    }

    public double getClientBalance(int id) {
        return clientStorage.getClientBalance(id);
    }

    public Client getClientById(int id) {
        return clientStorage.getClientById(id);
    }


}
