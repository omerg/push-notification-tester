import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class AndroidPush {

    /**
     * Replace SERVER_KEY with your SERVER_KEY generated from FCM
     * Replace DEVICE_TOKEN with your DEVICE_TOKEN
     */
    private static String SERVER_KEY = "AAAApeQ_AYM:APA91bFk9Y8MW1Wf_G-aX0MGGMFo5BhvL8gxD5ppNrjXQX1oa3YDfAU1P1ixUmZw1anwyc3n4Y2qKcCe2IfI1W3V4OaaY8uLJe_ohTLFHw1CyayoCW6wn4KAjzPJ7cC9KerhfNo6r3WX";
    private static String DEVICE_TOKEN = "cK29k4OKX9I:APA91bHL2rHUFHoSdERPEAIc3SpKKbpTctfVYHlWCKBqedALEAd1YVvvaI0H_whjd2yEFEKR7bHcdmHqeAOu2TdWqobnmvtZF1DAqDN7NRoc-qoMHECsziFLy176RlcPzRkQA8ORlPJj";


    /**
     * USE THIS METHOD to send push notification
     */
    public static void main(String[] args) throws Exception {
        String title = "My First Notification";
        String message = "Hello, I'm push notification";
        sendPushNotification(title, message);
    }


    /**
     * Sends notification to mobile, YOU DON'T NEED TO UNDERSTAND THIS METHOD
     */
    private static void sendPushNotification(String title, String message) throws Exception {
        String pushMessage = "{\"data\":{\"title\":\"" +
                title +
                "\",\"message\":\"" +
                message +
                "\"},\"to\":\"" +
                DEVICE_TOKEN +
                "\"}";
        // Create connection to send FCM Message request.
        URL url = new URL("https://fcm.googleapis.com/fcm/send");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization", "key=" + SERVER_KEY);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        // Send FCM message content.
        OutputStream outputStream = conn.getOutputStream();
        outputStream.write(pushMessage.getBytes());

        System.out.println(conn.getResponseCode());
        System.out.println(conn.getResponseMessage());
    }
}
