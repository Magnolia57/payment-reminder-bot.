package org.example.repositories;

import org.example.entities.Invoice;
import org.example.entities.InvoiceStatus;
import org.example.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class InvoiceRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;


    @Test
    void findByFreelancer_existingFreelancer_returnsInvoices() {
        User freelancer = new User();
        freelancer.setUserName("Marina1999");
        freelancer.setTelegramId(999999999999L);
        userRepository.save(freelancer);

        Invoice invoice = new Invoice();
        invoice.setFreelancer(freelancer);
        invoice.setService("Дизайн");
        invoice.setClientName("Иван");
        invoice.setDateOfCreation(LocalDate.of(2026, 11, 12));
        invoice.setDateExpiration(LocalDate.of(2026, 11, 21));
        invoice.setTotalSum(new BigDecimal(10000));
        invoice.setPaidSum(new BigDecimal(4000));
        invoice.setStatus(InvoiceStatus.CREATED);
        invoiceRepository.save(invoice);

        List<Invoice> invoices = invoiceRepository.findByFreelancer(freelancer);
        assertFalse(invoices.isEmpty());
        assertEquals(1, invoices.size());
        assertEquals(invoice.getId(), invoices.get(0).getId());
    }

    @Test

    void findByClient_noInvoice_isEmpty() {
        User client = new User();
        client.setTelegramId(999999999L);
        client.setUserName("Ivan23");
        userRepository.save(client);
        List<Invoice> invoices = invoiceRepository.findByClient(client);
        assertTrue(invoices.isEmpty());

    }
    @Test
    void findByClient_noClient_isEmpty(){
        User user = new User();
        user.setUserName("Vadim");
        user.setTelegramId(11111111111111111L);
        userRepository.save(user);

        User freelancer = new User();
        freelancer.setUserName("Marina1999");
        freelancer.setTelegramId(9999999999L);
        userRepository.save(freelancer);

        Invoice invoice = new Invoice();
        invoice.setFreelancer(freelancer);
        invoice.setService("Дизайн");
        invoice.setClientName("Иван");
        invoice.setDateOfCreation(LocalDate.of(2026, 11, 12));
        invoice.setDateExpiration(LocalDate.of(2026, 11, 21));
        invoice.setTotalSum(new BigDecimal(10000));
        invoice.setPaidSum(new BigDecimal(4000));
        invoice.setStatus(InvoiceStatus.CREATED);
        invoiceRepository.save(invoice);

        List<Invoice> invoices = invoiceRepository.findByClient(user);
        assertTrue(invoices.isEmpty());
    }

}
