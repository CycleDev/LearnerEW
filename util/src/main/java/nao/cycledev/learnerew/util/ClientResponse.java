package nao.cycledev.learnerew.util;

public class ClientResponse {

    private String url;

    private String content;

    private int statusCode;

    public ClientResponse(final String url, final String content, final int statusCode) {
        this.url = url;
        this.content = content;
        this.statusCode = statusCode;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
