package json.parser;

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
    /*
      You can get API_KEY from this below link. Once you have the API_KEY, you can fetch the top-headlines news.
      https://newsapi.org/s/cnn-api

      Fetch This following CNN API, It will return some news in Json data. Parse this data and construct
      https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=YOUR_API_KEY

      MY_API_KEY=6e93a87b2b594eb99b16b1e4683324a9

      After getting Json Format of the news, You can go to json validator link: https://jsonlint.com/ to see
      how it can be parsed.

      "articles": [{
		"source": {
			"id": "cnn",
			"name": "CNN"
		},
		"author": null,
		"title": "Who is affected by a shutdown? - CNN Video",
		"description": "CNN's Tom Foreman breaks down who is affected by a federal government partial shutdown.",
		"url": "http://us.cnn.com/videos/politics/2018/12/22/federal-partial-shutdown-by-the-numbers-foreman-ctn-vpx.cnn",
		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/181202171029-government-shutdown-capitol-file-super-tease.jpg",
		"publishedAt": "2018-12-23T01:09:50.8583193Z",
		"content": "Chat with us in Facebook Messenger. Find out what's happening in the world as it unfolds."
	   },{}]

	   Read the articles array and construct Headline news as source, author, title,description,url,urlToImage,publishedAt
	   and content. You need to design News Data Model and construct headline news.
	   You can store in Map and then into ArrayList as your choice of Data Structure.

	   You can follow How we implemented in Employee and JsonReaderUtil task.

	   Show output of all the headline news in to console.
	   Store into choice of your database and retrieve.

     */

    public static void main(String[] args) throws IOException, JSONException {
        String apiKey = "6e93a87b2b594eb99b16b1e4683324a9";
        String URL = "https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=" + apiKey;

//        JsonObject rootObject = new Json(new String(Files.readAllBytes(new File("src/json/parser/data.json").toPath())));

        NewsDataClass news = null;
        List<NewsDataClass> list1 = new ArrayList<>();
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
        if (jsonArray == null)
            jsonArray = rootObj.getAsJsonArray("articles");//Storing J object in the Array

        //Initialize Fields
        String source = null;
        String author = null;
        String title = null;
        String description = null;
        String url = null;
        String urlToImage = null;
        String publishedAt;
        String content;
        for (int i = 0; i < jsonArray.size() - 1; i++) {

            try {
                JsonObject jsonobject = jsonArray.get(i).getAsJsonObject();
                source = jsonobject.get("source").toString();
                System.out.println("SOURCE: " + source);
                author = jsonobject.get("author").toString();
                System.out.println("AUTHOR: " + author);
                title = jsonobject.get("title").toString();
                System.out.println("TITLE: " + title);
                description = jsonobject.get("description").toString();
                System.out.println("DESCRIPTION: " + description);
                url = jsonobject.get("url").toString();
                System.out.println("URL: " + url);
                urlToImage = jsonobject.get("urlToImage").toString();
                System.out.println("URL2I: " + urlToImage);
                publishedAt = jsonobject.get("publishedAt").toString();
                System.out.println("PUB AT: " + publishedAt);
                content = jsonobject.get("content").toString();
                System.out.println("CONTENT: " + content);

                //Object of HeadlineNews
                news = new NewsDataClass(source, author, title, description, url, urlToImage, publishedAt, content);
                list1.add(news);


            } catch (Exception ex) {

            }
        }

    }

    //using Inner Class
    private static class NewsDataClass {
        public NewsDataClass(String source, String author, String title, String description, String url, String urlToImage, String publishedAt, String content) {
        }
    }

}

