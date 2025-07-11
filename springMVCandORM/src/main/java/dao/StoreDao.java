package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class StoreDao {

	@Autowired
	HibernateTemplate ht;

	@Transactional
	public long getStoresCount() {
		
//		Store store = new Store();
//		store.setCount(100);
//		store.setName("Store1");
//		
//		ht.save(store);
		
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Long> result = (List<Long>) ht.find("select count(s) from Store s");
		return result.get(0);
	}
}
