package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.Filtering;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SubsamplingFilter implements Filtering {
    @Override
    public Set<Blueprint> filter(Set<Blueprint> blueprints) {
        return null;
    }
}
