package by.gavrilik.restApi.repository;

import by.gavrilik.restApi.model.Ads;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdsRepository extends JpaRepository<Ads, Long> {
}
