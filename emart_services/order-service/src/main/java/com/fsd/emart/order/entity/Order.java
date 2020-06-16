package com.fsd.emart.order.entity;


import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fsd.emart.order.model.Item;

import lombok.Data;

@Entity
@Data
@Table(name="user_order")
public class Order {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long o_id;
	private String o_username;
	@CreatedDate
    @Column(updatable = false, nullable = false)
    private Date o_created_time;
	private String o_status;
	@Lob
	@Column(columnDefinition="LONGTEXT")
	private String itemList;
	
	
}
