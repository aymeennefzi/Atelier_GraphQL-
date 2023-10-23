package GraphQL;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.RendezVous;
import repository.RendezVousRepository;

import java.util.List;

public class Querries implements GraphQLRootResolver {
    public RendezVousRepository rdbRepo;

    public Querries(RendezVousRepository rdbRepo) {
        this.rdbRepo = rdbRepo;
    }

    public List<RendezVous> getlist (){
        return rdbRepo.getListeRendezVous();
    }

}
