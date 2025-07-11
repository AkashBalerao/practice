package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StoreDao;

@Service
public class StoreService {
	
	@Autowired
	StoreDao storeDao;
	
	public long StoresCount() {
		return storeDao.getStoresCount();
	}
}
