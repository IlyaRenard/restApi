package by.gavrilik.restApi.service;

import by.gavrilik.restApi.model.Ads;
import by.gavrilik.restApi.repository.AdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdsServiceImpl implements AdsService {

    private final
    AdsRepository adsRepository;

    @Autowired
    public AdsServiceImpl(AdsRepository adsRepository) {
        this.adsRepository = adsRepository;
    }

    @Override
    public Ads getById(long id) {
       return adsRepository.getOne(id);
    }

    @Override
    public void save(Ads ads) {
        adsRepository.save(ads);
    }

    @Override
    public void delete(Long id) {
        adsRepository.deleteById(id);
    }

    @Override
    public List<Ads> getAll() {
       return adsRepository.findAll();
    }
}
