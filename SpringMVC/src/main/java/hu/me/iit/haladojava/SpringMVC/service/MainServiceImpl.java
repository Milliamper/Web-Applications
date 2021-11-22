package hu.me.iit.haladojava.SpringMVC.service;

import org.springframework.stereotype.Service;

@Service // így lesz belőle spring bean -> létrejön a manager bean
public class MainServiceImpl implements MainService {

	@Override
	public int mennyi(int adat) {
		return 2* adat;
	}

}
