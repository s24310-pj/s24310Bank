package pl.pjatk.s24310Bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankServiceIntegrationTests {

    @MockBean
    private TransactionStorage transactionStorage;
    @MockBean
    private ClientStorage clientStorage;

    @Autowired
    private final BankService bankService = new BankService(new TransactionStorage(), new ClientStorage());


    @Test
    void balanceLessThan0(){
        int id = 1;
        double balance = -20;

        Client client = bankService.registration(id, balance);

        assertThat(client).isNull();
    }

    @Test
    void wrongIdCashPayment(){
        int id = 30;
        double amount = 450;

        Transaction transaction = bankService.cashPayment(id, amount);

        assertThat(transaction).isNull();
    }

    @Test
    void amountGreaterThanBalanceForCashTransferOrder(){
        int id = 1;
        double amount = 10000000;

        Transaction transaction = bankService.cashTransferOrder(id, amount);

        assertThat(transaction).isNotNull();
    }

}
