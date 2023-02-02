package contact_ok;
//41deee38-a8df-4553-b633-2ad373c19388
//as1091@mail.com
//12345671091

import com.google.gson.Gson;
import dto.ResponseMessageDTO;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkDeleteById {
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYWJjQG1haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE2NzU3ODg2MjcsImlhdCI6MTY3NTE4ODYyN30.HQWiK5_U-7HnuF3cwtoA2Nst-SgwFwgTlPDe51iw7CA";
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();
    String id = "41deee38-a8df-4553-b633-2ad373c19388";
    @Test
    public void deleteContactById() throws IOException {
        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/"+"v1/contacts/"+id)
                .addHeader("Authorization",token)
                .delete()
                .build();
        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());
        ResponseMessageDTO messageDTO = gson.fromJson(response.body().string(), ResponseMessageDTO.class);
        String message = messageDTO.getMessage();
        System.out.println(message);
    }

}
