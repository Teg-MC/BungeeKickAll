package pw.teg.bungeekickall;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeKickAll extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this, new Command("bkickall", "bkickall.use") {
            @Override
            public void execute(CommandSender sender, String[] args) {
                if (args.length < 1) {
                    sender.sendMessage(TextComponent.fromLegacyText(ChatColor.RED + "Correct usage: /bkickall <message>"));
                    return;
                }

                StringBuilder builder = new StringBuilder();

                for (int i = 0; i < args.length; i++) {
                    builder.append(args[i]).append(" ");
                }

                String kickMessage = ChatColor.translateAlternateColorCodes('&', builder.toString().trim());

                for (ProxiedPlayer player : getProxy().getPlayers()) {
                    player.disconnect(TextComponent.fromLegacyText(kickMessage));
                }
            }
        });
    }

}
