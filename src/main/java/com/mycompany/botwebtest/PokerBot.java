package com.mycompany.botwebtest;

import java.util.ArrayList;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class PokerBot extends ListenerAdapter{
    public static JDA jda;
    private static String symbol = "chovk";
    public static ArrayList<Message> tempPokerInit = new ArrayList();
    
    public static boolean active(String token) throws LoginException{
        System.out.println("token" + token);
       if (token.length() < 1) {
            System.out.println("You have to provide a token as first argument!");
            System.exit(1);
        }
        // args[0] should be the token
        // We only need 2 intents in this bot. We only respond to messages in guilds and private channels.
        // All other events will be disabled.
        JDABuilder jdab = JDABuilder.createDefault(token,
            GatewayIntent.GUILD_MESSAGES,
            GatewayIntent.DIRECT_MESSAGES,
            GatewayIntent.GUILD_VOICE_STATES, 
            GatewayIntent.GUILD_EMOJIS,
            GatewayIntent.GUILD_MESSAGE_REACTIONS)
            .addEventListeners(new PokerBot()).setActivity(Activity.playing("Use chovk"));
        jda = jdab.build();
        
        return jda == null;
    }

    public static JDA getJda() {
        return jda;
    }
}