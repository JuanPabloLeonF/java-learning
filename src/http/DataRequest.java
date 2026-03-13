package http;

public record DataRequest(String body, String title, String userId) {
    @Override
    public String toString() {
        return "{"
                + "\"body\":\"" + body + "\","
                + "\"title\":\"" + title + "\","
                + "\"userId\":\"" + userId + "\""
                + "}";
    }
}
