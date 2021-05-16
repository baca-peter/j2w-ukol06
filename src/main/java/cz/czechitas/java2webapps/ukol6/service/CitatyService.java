package cz.czechitas.java2webapps.ukol6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitatyService {
    private final NahodneCisloService nahodneCisloService;
    private final CitatyRepository citatyRepository;

    @Autowired
    public CitatyService(NahodneCisloService nahodneCisloService, CitatyRepository citatyRepository) {
        this.nahodneCisloService = nahodneCisloService;
        this.citatyRepository = citatyRepository;
    }

    public String nahodnyCitat() {
        return this.citatyRepository.citat(this.nahodneCisloService.dejNahodneCislo(this.citatyRepository.pocet()));
    }

    public String konkretniCitat(int cislo) {
        if (cislo < this.citatyRepository.pocet()) {
            return this.citatyRepository.citat(cislo);
        } else {
            return String.format("Citát s číslom %d neexistuje.", cislo);
        }
    }

}
