package endpoints;

public enum Endpoints {
    ADMIN_MAPPINGS("/__admin/mappings");

    private final String endpoint;

    Endpoints(String path){
        this.endpoint=path;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
