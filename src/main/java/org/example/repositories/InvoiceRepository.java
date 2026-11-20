package org.example.repositories;

import org.example.entities.Invoice;
import org.example.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    List <Invoice> findByClient (User client);
    List <Invoice> findByFreelancer (User freelancer);
}
