package com.webalk.futas.Service;

import com.webalk.futas.Service.ServiceDTO.Futas;

import java.util.List;

public interface FutasService {
	List<Futas> getAllFutas();

	Futas createFutas(Futas toFutas);

	void deleteFutasById(Long id);

	void updateFutas(Futas futas);

	Futas getBestFutas(int futasTipus);
}
