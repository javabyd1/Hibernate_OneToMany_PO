package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ORDERS_ID")
    private int ordersId;

    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
    private User user;

    @Column(name = "THING_LIST")
    private String thingList;

    @Column(name = "ORDERS_DATE")
    private LocalDate ordersDate;

}
