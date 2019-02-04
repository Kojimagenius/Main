package dao;

import model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderDAO extends JpaRepository<Order, Long> {

    @Query("SELECT ob from orders ob where ob.id = :id")
    Order getById(@Param("id") long id);
}
