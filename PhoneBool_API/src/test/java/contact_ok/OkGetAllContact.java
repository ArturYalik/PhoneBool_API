package contact_ok;

import com.google.gson.Gson;
import dto.ContactDTO;
import dto.GetAllContactsDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkGetAllContact {
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYWJjQG1haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE2NzU3ODg2MjcsImlhdCI6MTY3NTE4ODYyN30.HQWiK5_U-7HnuF3cwtoA2Nst-SgwFwgTlPDe51iw7CA";
    OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();

    @Test
    public void getAllContacts() throws IOException {
        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/"+"v1/contacts")
                .addHeader("Authorization",token)
                .build();

        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());
        GetAllContactsDTO contactsDTO = gson.fromJson(response.body().string(), GetAllContactsDTO.class);

        for(ContactDTO contactDTO:contactsDTO.getContacts()){
            System.out.println(contactDTO.getId());
            System.out.println(contactDTO.getEmail());
            System.out.println(contactDTO.getPhone());
            System.out.println("================================");
        }

    }


}
