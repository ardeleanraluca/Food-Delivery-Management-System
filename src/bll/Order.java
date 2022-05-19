package bll;

import java.io.Serializable;
import java.time.ZoneId;
import java.util.Date;

public class Order implements Serializable, Comparable<Order> {
    private int id;
    private int idClient;
    private Date orderDate;
    private float totalPrice;

    public Order(int idClient, float totalPrice) {
        this.idClient = idClient;
        this.totalPrice = totalPrice;
        orderDate = new Date();
        this.id = new DeliveryService().getPlacedOrders().size() + 1;
    }


    public int getId() {
        return id;
    }

    public int getIdClient() {
        return idClient;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id == order.id;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idClient;
        result = 31 * result + orderDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                "}\n";
    }

    @Override
    public int compareTo(Order o) {
        return o.id - this.id;
    }

    public int getDay() {
        return orderDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().getDayOfMonth();
    }

    public int getMonth() {
        return orderDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().getMonthValue();
    }

    public int getYear() {
        return orderDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().getYear();
    }


}
