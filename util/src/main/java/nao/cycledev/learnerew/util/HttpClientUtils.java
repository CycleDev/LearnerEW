package nao.cycledev.learnerew.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;


public final class HttpClientUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

    private static final int CONNECTION_TIMEOUT = 10000;

    private HttpClientUtils() {
    }

    /**
     * Performs GET request on requested url and reads the response content from it.
     *
     * @param url url to get response from
     *
     * @return http GET response
     * @throws IOException if any error occurs
     */
    public static ClientResponse proceedGetRequest(final String url) throws IOException {
        return proceedGetRequest(url, Collections.EMPTY_MAP);
    }

    public static ClientResponse proceedGetRequest(final String url, final Map<String, String> headers) throws IOException {
        try (final CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(createRequestTimeout()).build()) {
            final HttpGet request = new HttpGet(url);
            for (String headerName : headers.keySet()) {
                request.setHeader(headerName, headers.get(headerName));
            }

            final HttpResponse response = client.execute(request);
            final String responseString = HttpClientUtils.readResponseContent(response);
            final int responseStatus = response.getStatusLine().getStatusCode();
            final ClientResponse clientResponse = new ClientResponse(url, responseString, responseStatus);

            LOGGER.trace("Response : {}", responseString);
            LOGGER.debug("Response Code : {}", responseStatus);

            return clientResponse;
        }
    }

    /**
     * Performs POST request on requested url with form parameters and reads the response content from it.
     *
     * @param url url to get response from
     *
     * @return http POST response
     * @throws IOException if any error occurs
     */
    public static ClientResponse proceedPostRequest(final String url, final List<NameValuePair> formParameters) throws IOException {
        try (final CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(createRequestTimeout()).build()) {
            final HttpPost request = new HttpPost(url);
            request.setEntity(new UrlEncodedFormEntity(formParameters));

            final HttpResponse response = client.execute(request);
            final String responseString = HttpClientUtils.readResponseContent(response);
            final int responseStatus = response.getStatusLine().getStatusCode();
            final ClientResponse clientResponse = new ClientResponse(url, responseString, responseStatus);

            LOGGER.trace("Response : {}", responseString);
            LOGGER.debug("Response Code : {}", responseStatus);

            return clientResponse;
        }
    }

    /**
     * Performs POST request with json content on requested url and reads the response content from it.
     *
     * @param url url to get response from
     *
     * @return http POST response
     * @throws IOException if any error occurs
     */
    public static ClientResponse proceedPostRequest(final String url, final String json, final Map<String, String> headers) throws IOException {
        try (final CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(createRequestTimeout()).build()) {
            final HttpPost request = new HttpPost(url);
            request.addHeader(HTTP.CONTENT_TYPE, "application/json; charset=UTF-8");
            if (headers != null) {
                for (String headerName : headers.keySet()) {
                    request.setHeader(headerName, headers.get(headerName));
                }
            }
            HttpEntity entry = new StringEntity(json, ContentType.create("application/json", Charset.forName("UTF-8")));
            request.setEntity(entry);

            final HttpResponse response = client.execute(request);
            final String responseString = HttpClientUtils.readResponseContent(response);
            final int responseStatus = response.getStatusLine().getStatusCode();
            final ClientResponse clientResponse = new ClientResponse(url, responseString, responseStatus);

            LOGGER.trace("Response : {}", responseString);
            LOGGER.debug("Response Code : {}", responseStatus);

            return clientResponse;
        }
    }

    /**
     * Performs POST request with json content on requested url and reads the response content from it.
     *
     * @param url url to get response from
     *
     * @return http POST response
     * @throws IOException if any error occurs
     */
    public static ClientResponse proceedPostRequest(final String url, final String json) throws IOException {
        try (final CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(createRequestTimeout()).build()) {
            final HttpPost request = new HttpPost(url);
            request.addHeader(HTTP.CONTENT_TYPE, "application/json; charset=UTF-8");
            HttpEntity entry = new StringEntity(json, ContentType.create("application/json", Charset.forName("UTF-8")));
            request.setEntity(entry);

            final HttpResponse response = client.execute(request);
            final String responseString = HttpClientUtils.readResponseContent(response);
            final int responseStatus = response.getStatusLine().getStatusCode();
            final ClientResponse clientResponse = new ClientResponse(url, responseString, responseStatus);

            LOGGER.trace("Response : {}", responseString);
            LOGGER.debug("Response Code : {}", responseStatus);

            return clientResponse;
        }
    }

    /**
     * Performs DELETE request with json content on requested url and reads the response content from it.
     *
     * @param url url to get response from
     *
     * @return http DELETE response
     * @throws IOException if any error occurs
     */
    public static ClientResponse proceedDeleteRequest(final String url) throws IOException {
        try (final CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(createRequestTimeout()).build()) {
            final HttpDelete request = new HttpDelete(url);
            request.addHeader(HTTP.CONTENT_TYPE, "application/json; charset=UTF-8");

            final HttpResponse response = client.execute(request);
            final String responseString = HttpClientUtils.readResponseContent(response);
            final int responseStatus = response.getStatusLine().getStatusCode();
            final ClientResponse clientResponse = new ClientResponse(url, responseString, responseStatus);

            LOGGER.trace("Response : {}", responseString);
            LOGGER.debug("Response Code : {}", responseStatus);

            return clientResponse;
        }
    }

    private static String readResponseContent(final HttpResponse response) throws IOException {
        final StringBuilder result = new StringBuilder();

        try (final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent(), "UTF8"))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append("\n");

            }
        }

        return result.toString();
    }

    private static RequestConfig createRequestTimeout() {
        return RequestConfig.custom().setConnectTimeout(CONNECTION_TIMEOUT).setConnectionRequestTimeout(CONNECTION_TIMEOUT).build();
    }
}

