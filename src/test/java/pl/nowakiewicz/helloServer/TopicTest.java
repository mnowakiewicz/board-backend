package pl.nowakiewicz.helloServer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopicTest {

    @Test
    public void createdTopicHasNoMessages() {
        Topic created = Topic.create("testowy");

        assertTrue(created.messages.isEmpty());
    }

    @Test
    public void createdTopicHasCorrectName() {
        Topic created = Topic.create("testowy2");

        assertEquals("testowy2", created.name);
    }

    @Test
    public void createdAfterAddMessageHasOneMessage() {
        Topic created = Topic.create("testowy2");
        Topic newTopic = created.addMessage(new Message("maciek", "content"));

        assertTrue(newTopic.messages.length() == 1);
    }

    @Test
    public void createdAfterAddMessageHasSameTopicName() {
        Topic created = Topic.create("testowy2");
        Topic newTopic = created.addMessage(new Message("maciek", "content"));

        assertEquals( "testowy2", newTopic.name);
    }

    @Test
    public void createdAfterAddMessageHasTwoMessages() {
        Topic newTopic = Topic.create("testowy2")
                .addMessage(new Message("maciek", "content"))
                .addMessage(new Message("maciek", "content2"));


        assertEquals(2, newTopic.messages.length());
    }

    @Test
    public void addedMessageIsLast() {
        Message expected = new Message("maciek", "content3");
        Topic newTopic = Topic.create("testowy2")
                .addMessage(new Message("maciek", "content"))
                .addMessage(new Message("maciek", "content2"))
                .addMessage(expected);




        assertEquals(expected, newTopic.messages.last());
    }


}