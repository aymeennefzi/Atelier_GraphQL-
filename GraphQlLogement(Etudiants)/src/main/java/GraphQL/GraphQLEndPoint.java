package GraphQL;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.RendezVousRepository;

import javax.servlet.annotation.WebServlet;

@WebServlet("/graphql")
public class GraphQLEndPoint extends SimpleGraphQLServlet {
    public GraphQLEndPoint(){
        super(buildSchema());
    }
    private static GraphQLSchema buildSchema() {
        RendezVousRepository redVous=new RendezVousRepository();
        return SchemaParser.newParser()
                .file("schema.graphql")
                .resolvers(new Querries(redVous))
                .build()
                .makeExecutableSchema();
    }
}