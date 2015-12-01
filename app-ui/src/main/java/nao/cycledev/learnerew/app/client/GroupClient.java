package nao.cycledev.learnerew.app.client;

import com.google.gson.reflect.TypeToken;
import nao.cycledev.learnerew.util.ClientResponse;
import nao.cycledev.learnerew.util.SerializationUtils;
import nao.cycledev.learnerew.view.GroupView;
import nao.cycledev.learnerew.view.info.GroupInfo;
import nao.cycledev.learnerew.util.HttpClientUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class GroupClient {

    @Value("${api.url}")
    private String apiUrl;

    public List<GroupView> findAll() throws IOException {
        final String url = apiUrl + "/groups";
        final ClientResponse response = HttpClientUtils.proceedGetRequest(url);

        return SerializationUtils.getGson().fromJson(response.getContent(), new TypeToken<List<GroupView>>(){}.getType());
    }

    public GroupView find(String id) throws IOException {
        final String url = apiUrl + "/groups/" + id;
        final ClientResponse response = HttpClientUtils.proceedGetRequest(url);

        return SerializationUtils.getGson().fromJson(response.getContent(), GroupView.class);
    }

    public void delete(String id) throws IOException {
        final String url = apiUrl + "/groups/" + id;
        HttpClientUtils.proceedDeleteRequest(url);
    }

    public void save(GroupInfo group) throws IOException {
        final String url = apiUrl + "/groups/";
        HttpClientUtils.proceedPostRequest(url, SerializationUtils.getGson().toJson(group));
    }

}
