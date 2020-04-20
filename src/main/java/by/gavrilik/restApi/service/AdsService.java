package by.gavrilik.restApi.service;

import by.gavrilik.restApi.model.Ads;

import java.util.List;

public interface AdsService {

        Ads getById(long id);

        void save(Ads ads);

        void delete(Long id);

        List<Ads> getAll();
}
