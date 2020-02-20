package fr.eni_ecole.jee.rest;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.eni_ecole.jee.bean.Stagiaire;
import fr.eni_ecole.jee.dal.StagiaireDAO;

@Path("/stagiaires")
public class GestionStagiaires 
{
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Stagiaire> getStagiaires() throws SQLException
	{
		return StagiaireDAO.lister();
	}
	
	@GET
    @Path("/html")
    @Produces("text/html")
    public Response getStagiairesHtml()
	{
		
		List<Stagiaire> lst=null;
		try 
		{
			lst=StagiaireDAO.lister();
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

        return Response
                .ok()
                .entity(lst)
                .build();
    }
	
	
	
}
