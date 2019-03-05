import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.config.HttpConfiguration;

public class RESTApi extends Service<Configuration> {

    public void initialize(Bootstrap<Configuration> bootstrap) {

    }

    public void run(Configuration configuration, Environment environment) {
        environment.addResource(RESTApiResource.class);

        HttpConfiguration httpConfiguration = new HttpConfiguration();
        httpConfiguration.setPort(9999);

        configuration.setHttpConfiguration(httpConfiguration);
    }

    public static void main(String[] args) throws Exception {
        new RESTApi().run(args);
    }
}