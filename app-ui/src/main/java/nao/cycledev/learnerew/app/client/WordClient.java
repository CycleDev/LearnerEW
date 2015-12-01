package nao.cycledev.learnerew.app.client;

import com.google.gson.reflect.TypeToken;
import nao.cycledev.learnerew.view.WordView;
import nao.cycledev.learnerew.view.info.WordInfo;
import nao.cycledev.learnerew.util.ClientResponse;
import nao.cycledev.learnerew.util.HttpClientUtils;
import nao.cycledev.learnerew.util.SerializationUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class WordClient {

    @Value("${api.url}")
    private String apiUrl;

    public List<WordView> findAll() throws IOException {
        final String url = apiUrl + "/words";
        final ClientResponse response = HttpClientUtils.proceedGetRequest(url);

        return SerializationUtils.getGson().fromJson(response.getContent(), new TypeToken<List<WordView>>(){}.getType());
    }

    public WordView find(String id) throws IOException {
        final String url = apiUrl + "/words/" + id;
        final ClientResponse response = HttpClientUtils.proceedGetRequest(url);

        return SerializationUtils.getGson().fromJson(response.getContent(), WordView.class);
    }

    public void delete(String id) throws IOException {
        final String url = apiUrl + "/words/" + id;
        HttpClientUtils.proceedDeleteRequest(url);
    }

    public void save(WordInfo word) throws IOException {
        final String url = apiUrl + "/words/";
        HttpClientUtils.proceedPostRequest(url, SerializationUtils.getGson().toJson(word));
    }

}
