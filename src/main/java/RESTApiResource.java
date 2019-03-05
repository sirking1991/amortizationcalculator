import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.sirking1991.amortization.*;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class RESTApiResource {

    @GET
    public AmortSched[] calc(@QueryParam("amount") double amount,
                             @QueryParam("year") int year,
                             @QueryParam("interest") double interest) {

        Amortization amortization = new Amortization(amount, year, interest);
        AmortSched[] schedule = amortization.getSchedule();

        return schedule;
    }

}
