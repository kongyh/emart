package com.fsd.emart.order.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;

import com.fsd.emart.order.common.OrderStatus;

import lombok.Data;

@Entity
@Data
public class Order {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long order_id;
	private String order_username;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Item> order_item_list;
	@CreatedDate
    @Column(updatable = false, nullable = false)
    private Date order_created_time;
	private OrderStatus order_status;
}
