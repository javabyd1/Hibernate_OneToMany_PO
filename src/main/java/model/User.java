package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USER_DETAILS")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int userId;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "ADRESS")
    private String adres;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<Orders> orderList = new ArrayList<Orders>();
}
