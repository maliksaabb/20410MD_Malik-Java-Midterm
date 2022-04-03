package json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class CnnAPI {
    /** INSTRUCTIONS
     * Go to this URL: https://newsapi.org/s/cnn-api
     *
     * Get your API Key from this website. Once you have your key, you can append your key to the end of the URL, as
     * shown below.
     *
     *  https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=YOUR_API_KEY
     *
     * When you navigate to that full URL, you will be submitting a request, and the response should be CNN's
     * top headline news.
     *
     * After retrieving the JSON response, you can go to the following link to validate that it is, in fact, valid JSON:
     *  https://jsonlint.com/
     *
     *      "articles": [{
     * 		"source": {
     * 			"id": "cnn",
     * 			"name": "CNN"
     *                },
     * 		"author": null,
     * 		"title": "Who is affected by a shutdown? - CNN Video",
     * 		"description": "CNN's Tom Foreman breaks down who is affected by a federal government partial shutdown.",
     * 		"url": "http://us.cnn.com/videos/politics/2018/12/22/federal-partial-shutdown-by-the-numbers-foreman-ctn-vpx.cnn",
     * 		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/181202171029-government-shutdown-capitol-file-super-tease.jpg",
     * 		"publishedAt": "2018-12-23T01:09:50.8583193Z",
     * 		"content": "Chat with us in Facebook Messenger. Find out what's happening in the world as it unfolds."
     *       },{}]
     *
     * Follow along in the code implemented below to understand what is going on. You must implement the rest of the
     * code in the for loop. Your goal is to create a new object of the inner class for each headline your JSON response
     * contains. You will assign the values that are being retrieved by the JSON parser, to the object attributes. Then,
     * store each of those objects in the provided List<NewsData>
     *
     * You can also choose to store these instances in a Map, instead.
     *
     * Lastly, store the data that is in your data structure into a database table, called `news_headlines`, and then
     * demonstrate that you can read from the table and print all the results to the console
     *
     * Feel free to use the JsonReaderUtil for reference.
     *
     */

    public static void main(String[] args) throws IOException, JSONException {
        String apiKey = "";
        String URL = "";

        NewsData news = null;
        List<NewsData> newsDataList = new ArrayList<>();
        java.net.URL url1 = new URL(URL);
        URLConnection request = url1.openConnection();//establish the connection with  the server
        request.connect();

        JsonArray jsonArray = null;
        JsonObject rootObj = null;
        JsonParser jp = new JsonParser();

        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

        if (root instanceof JsonObject) {
            rootObj = root.getAsJsonObject();
        } else if (root instanceof JsonArray) {
            jsonArray = root.getAsJsonArray();
        }

        // If response is not a JSON array, then convert the response into a JSON array
        if (jsonArray == null)
            jsonArray = rootObj.getAsJsonArray("articles");

        String source;
        String author;
        String title;
        String description;
        String url;
        String urlToImage;
        String publishedAt;
        String content;

        for (int i = 0; i < jsonArray.size() - 1; i++) {

            try {
                JsonObject jsonobject = jsonArray.get(i).getAsJsonObject();

                title = jsonobject.get("title").toString();
                System.out.println("TITLE: " + title);

                // Implement the remaining code, using the provided example within this try block

            } catch (Exception ex) {

            }
        }
    }

    // Inner Class
    private static class NewsData {

        public NewsData(String source, String author, String title, String description, String url, String urlToImage,
                        String publishedAt, String content) {


        }
    }

}

