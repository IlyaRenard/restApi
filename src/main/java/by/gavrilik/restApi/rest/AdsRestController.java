package by.gavrilik.restApi.rest;


import by.gavrilik.restApi.model.Ads;
import by.gavrilik.restApi.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ads")
public class AdsRestController {

    @Autowired
    private AdsService adsService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Ads> getAds(@PathVariable("id") Long adsId){
        if (adsId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Ads customer = this.adsService.getById(adsId);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Ads> saveCustomer(@RequestBody @Valid Ads ads) {
        HttpHeaders headers = new HttpHeaders();

        if (ads == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.adsService.save(ads);
        return new ResponseEntity<>(ads, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<Ads> updateCustomer(@RequestBody @Valid Ads ads, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (ads == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.adsService.save(ads);

        return new ResponseEntity<>(ads, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Ads> deleteCustomer(@PathVariable("id") Long id) {
        Ads customer = this.adsService.getById(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.adsService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Ads>> getAllCustomers() {
        List<Ads> ads = this.adsService.getAll();

        if (ads.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ads, HttpStatus.OK);
    }
}
