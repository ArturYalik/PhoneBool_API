package contact_ok;

import com.google.gson.Gson;
import dto.*;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkAddContactTest {
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYWJjQG1haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE2NzU3ODg2MjcsImlhdCI6MTY3NTE4ODYyN30.HQWiK5_U-7HnuF3cwtoA2Nst-SgwFwgTlPDe51iw7CA";
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();

    @Test
    public void addTest() throws IOException {
        ContactDTO contact = ContactDTO.builder()
                .name("Name")
                .lastName("LastName")
                .email("Email@mail.com")
                .phone("12345678901")
                .address("Haifa")
                .description("DTO")
                .build();
        RequestBody requestBody = RequestBody.create(gson.toJson(contact), JSON);
        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/" + "v1/contacts")
                .addHeader("Authorization", token)
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());
        ResponseMessageDTO messageDTO = gson.fromJson(response.body().string(), ResponseMessageDTO.class);
        String message = messageDTO.getMessage();
        System.out.println(message);
    }

}
