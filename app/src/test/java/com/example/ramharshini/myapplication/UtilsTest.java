package com.example.ramharshini.myapplication;

import android.content.Context;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.BasicNetwork;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class UtilsTest extends InstrumentationTestCase {

    private ApiCallBack apiCallBack = null;

    Context context = mock(Context.class);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void makeCall() throws IOException {
// Create a MockWebServer. These are lean enough that you can create a new
        // instance for every unit test.
        MockWebServer server = new MockWebServer();

        String strMockResponse = "{\n" +
                "   \"success\": true,\n" +
                "    \"str\": \"ramakrishna\"\n" +
                "}";
        // Schedule some responses.
        server.enqueue(new MockResponse().setBody(strMockResponse));

        // Start the server.
        server.start();

        // Ask the server for its URL. You'll need this to make HTTP requests.
        HttpUrl baseUrl = server.url("http://www.mocky.io/v2/5c19be34320000570064ad14");

        // Exercise your application code, which should make those HTTP requests.
        // Responses are returned in the same order that they are enqueued.
        //Chat chat = new Chat(baseUrl);

        //chat.loadMore();

        Utils.makeCall(context,"test name",apiCallBack);
        //assertEquals("", chat.messages());

        // Optional: confirm that your app made the HTTP requests you were expecting.


        // Shut down the server. Instances cannot be reused.
        server.shutdown();

    }
}