package com.fsd.emart.user.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
@Entity
public class Buyer {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long b_id;
    private String b_name;
    private String b_password;
    private String b_email;
    private String b_mobile;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Date b_created_time;
    
    @Override
    public String toString() {
    	return "Buyer{" +
                "b_id=" + b_id +
                ", b_name='" + b_name + 
                ", b_password=" + b_password +
                ", b_email=" + b_email +
                ", b_mobile=" + b_mobile +
                '}';
    }
	
    

}
