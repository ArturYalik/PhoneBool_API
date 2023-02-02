package contact_ok;
//b1719b24-9d0f-4fa1-a5a1-82ce33434561
//as1195@mail.com
//12345671195


import com.google.gson.Gson;
import dto.ContactDTO;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.testng.annotations.Test;

public class OkEditContactTest {
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYWJjQG1haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE2NzU3ODg2MjcsImlhdCI6MTY3NTE4ODYyN30.HQWiK5_U-7HnuF3cwtoA2Nst-SgwFwgTlPDe51iw7CA";
    OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();
    String id = "ff89e563-7156-42ad-9e65-6bea5271a7e8";
    ContactDTO contact = ContactDTO.builder()
            .id(id)
            .name("Name")
            .lastName("LastName")
            .email("Email@mail.com")
            .phone("12345678901")
            .address("Haifa")
            .description("DTO")
            .build();

    @Test
    public void additContact() {
        RequestBody requestBody = RequestBody.create(gson.toJson(contact),JSON);
        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/"+"v1/contacts/")
                .post(requestBody)
                .build();
    }

}
