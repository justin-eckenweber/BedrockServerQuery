package me.justin.bedrockserverquery;

import me.justin.bedrockserverquery.data.BedrockQuery;

public class Main {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Please define an IP-Address and Port. For example java -jar ./MyJar.jar myserver.com 19132");
            return;
        }

        final String address = args[0];

        try {
            final int port = Integer.parseInt(args[1]);

            System.out.println("Performing query on " + address + ":" + port + "...");
            var query = BedrockQuery.create(address, port);
            if (query.online()) {
                System.out.println("Query succeeded! Printing information:");
                System.out.println("Online: yes");
                System.out.println("MOTD: " + query.motd());
                System.out.println("Protocol Version: " + query.protocolVersion());
                System.out.println("Minecraft Version: " + query.minecraftVersion());
                System.out.println("Player Count: " + query.playerCount());
                System.out.println("Max Players: " + query.maxPlayers());
                System.out.println("Server Software: " + query.software());
                System.out.println("Gamemode: " + query.gamemode());
            } else {
                System.out.println("Couldn't gather information from " + address + ":" + port + "!");
                System.out.println("Server is offline or given information incorrect.");
            }

        } catch (Exception ex) {
            System.out.println("Port is not a valid number.");
        }

    }

}