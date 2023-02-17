package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws BlueprintPersistenceException, BlueprintNotFoundException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bpServices = ac.getBean(BlueprintsServices.class);

        System.out.println(bpServices.getAllBlueprints());

        Point[] pts=new Point[]{new Point(0, 0),new Point(0, 0), new Point(1, 1), new Point(0, 0)};
        Blueprint bp=new Blueprint("john", "thepaint",pts);
        Blueprint bp1=new Blueprint("johncito", "thepaint",pts);
        Blueprint bp2=new Blueprint("johncito", "thepaint2.0",pts);

        bpServices.addNewBlueprint(bp);
        bpServices.addNewBlueprint(bp1);
        bpServices.addNewBlueprint(bp2);

        System.out.println("Probando filtros: " + bpServices.getAllBlueprints());

        System.out.println("Searching specific blueprint: " + bpServices.getBlueprint(bp.getAuthor(), bp.getName()));
        System.out.println("Searching blueprint by author: " + bpServices.getBlueprintsByAuthor(bp1.getAuthor()));
    }
}
