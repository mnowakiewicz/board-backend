package pl.nowakiewicz.helloServer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class Message {
    public final String author;
    public final String content;

    @JsonCreator
    public Message(@JsonProperty("author")String author, @JsonProperty("content")String content) {
        this.author = author;
        this.content = content;
    }
}
