public class HealthCheck extends com.yammer.metrics.core.HealthCheck {
    protected HealthCheck(String name) {
        super(name);
    }

    protected Result check() throws Exception {
        return null;
    }
}
