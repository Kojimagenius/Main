package model;

import javax.persistence.*;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private Long id;
    @Column(name = "city")
    private String StartPoint;
    @Column(name = "destination")
    private String DestinationPoint;
    @Column(name = "orderer")
    private User Orderer;


    public Order(){}
    public Order(Long id,String start, String dest){
        this.id = id;
        StartPoint = start;
        DestinationPoint = dest;
    }

    public Long getId() {
        return id;
    }

    public String getDestinationPoint() {
        return DestinationPoint;
    }

    public String getStartPoint() {
        return StartPoint;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDestinationPoint(String destinationPoint) {
        DestinationPoint = destinationPoint;
    }

    public void setStartPoint(String startPoint) {
        StartPoint = startPoint;
    }

    public void setOrderer(User orderer) {
        Orderer = orderer;
    }

    public User getOrderer() {
        return Orderer;
    }
    @Override
    public String toString(){
        return "Order: id -" + id+"Start Porint - " + StartPoint+" Destination -"+DestinationPoint+" Orderer - " + Orderer;
    }
}
