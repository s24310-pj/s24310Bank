package pl.pjatk.s24310Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;

@SpringBootApplication
public class S24310BankApplication {


    public S24310BankApplication(BankService bankService) {

        System.out.println(bankService.getClientById(1));
        bankService.registration(4, 500);
        bankService.cashTransferOrder(4, 200);
        bankService.cashPayment(1, 5000);

    }


    public static void main(String[] args) {
        SpringApplication.run(S24310BankApplication.class, args);
    }

}
