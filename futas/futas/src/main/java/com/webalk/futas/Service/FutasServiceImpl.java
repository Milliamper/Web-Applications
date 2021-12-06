package com.webalk.futas.Service;

import com.webalk.futas.Exceptions.NoSuchEntity;
import com.webalk.futas.Repository.FutasRepository;
import com.webalk.futas.Service.ServiceDTO.Futas;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FutasServiceImpl implements FutasService{

    private final FutasRepository futasRepository;

    public FutasServiceImpl(FutasRepository futasRepository) {
        this.futasRepository = futasRepository;
    }

    @Override
    public List<Futas> getAllFutas() {
       List<Futas> futasLista = new ArrayList<>();
       for(com.webalk.futas.Entity.Futas futas : futasRepository.findAll()){
           futasLista.add(new Futas(futas));
       }
       return futasLista;
    }

    @Override
    public Futas createFutas(Futas toFutas) {
        return new Futas(futasRepository.save(toFutas.toEntity()));
    }

    @Override
    public void deleteFutasById(Long id) {
        try{
            futasRepository.deleteById(id);
        }catch (EmptyResultDataAccessException ex){
            throw new NoSuchEntity();
        }
    }

    @Override
    public void updateFutas(Futas futas) {
        Optional<com.webalk.futas.Entity.Futas> futasById = futasRepository.findById(futas.getId());
        if(futasById.isEmpty()){
            throw new NoSuchEntity();
        }
        else {
            futasRepository.save(futas.toEntity());
        }
    }

    @Override
    public Futas getBestFutas(int futasTipus) {
        Optional<com.webalk.futas.Entity.Futas> futasByTipus = futasRepository.getFirstByFutasTipusOrderByTavDesc(futasTipus);
        if(futasByTipus.isEmpty()){
            throw new NoSuchEntity();
        }
        return new Futas(futasByTipus);
    }

}
