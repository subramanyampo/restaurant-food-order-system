package com.example.entity;

import java.util.List;

//import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class orders {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private user user;
	    @ManyToMany
	    @JoinTable(
	            name = "order_items",  // Specify the name of the join table
	            //joinColumns = @JoinColumn(name = "order_id"),  // Column in the join table that references Orders
	            //inverseJoinColumns = @JoinColumn(name = "item_id")  // Column in the join table that references Items
	            joinColumns = @JoinColumn(name="orderid"),
	            
	            inverseJoinColumns = @JoinColumn(name="itemid")
	           
	        )
	    List<items> items;

	    
		public List<items> getItems() {
			return items;
		}

		public void setItems(List<items> items) {
			this.items = items;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public user getUser() {
			return user;
		}

		public void setUser(user user) {
			this.user = user;
		}

		

}
