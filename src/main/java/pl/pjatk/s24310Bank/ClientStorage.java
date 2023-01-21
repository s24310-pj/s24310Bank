package pl.pjatk.s24310Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientStorage {

    Client client1 = new Client(1, 2500);
    Client client2 = new Client(2, 5000);
    Client client3 = new Client(3, 25000);

    List<Client> clientList = new ArrayList<>();

    public List<Client> getClientList() {
        return clientList;
    }

    public ClientStorage() {
        clientList.add(client1);
        clientList.add(client2);
        clientList.add(client3);
    }


    public Client getClientById(int id) {
        for (Client client : clientList) {
            if (client.getId() == (id)) {
                return clientList.get(clientList.indexOf(client));
            }
        }
        System.out.println("Nie ma klienta o takim id");
        return null;
    }


    public double getClientBalance(int id) {
        for (Client client : clientList) {
            if (client.getId() == id) {
                return client.getBalance();
            }
        }
        System.out.println("Nie ma klienta o takim id");
        return 0;
    }


}
