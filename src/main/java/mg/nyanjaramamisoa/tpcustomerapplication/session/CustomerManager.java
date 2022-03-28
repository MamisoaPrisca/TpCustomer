/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package mg.nyanjaramamisoa.tpcustomerapplication.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mg.nyanjaramamisoa.tpcustomerapplication.entities.Customer;

/**
 *
 * @author nyamp
 * Gère la persistance des Customers.
 */
@Stateless
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    /**
     * select * from customer
     * @return 
     */
    public List<Customer> getAllCustomers() {
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
    }
    /**
     * Update Customer
     * @param customer
     * @return 
     */    
    public Customer update(Customer customer) {
        return em.merge(customer);  
    }   

    public void persist(Customer customer) {
        em.persist(customer);
    }
    public Customer getCustomer(int idCustomer) {  
        return em.find(Customer.class, idCustomer);  
    }
}
