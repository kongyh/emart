package com.fsd.emart.item.test;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fsd.emart.item.repository.ItemRepository;

public class TestRepository extends TestTemplate {
	@Autowired ItemRepository itemRepository;
   
}
