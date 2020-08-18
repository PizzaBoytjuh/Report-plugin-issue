package nmzc.naaktm0lrat.reports.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nmzc.naaktm0lrat.reports.Main;
import nmzc.naaktm0lrat.reports.utils.Utils;

public class CommandReport implements CommandExecutor{
	private Main plugin;
	
	public CommandReport(Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("report").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat("&c&lYou may not execute this command"));
			return true;
		} else {
			Player p = (Player)sender;
			if(args.length != 2)  {
				p.sendMessage(Utils.chat("&c&lPlease use /report {player} {offence}!"));
				return true;
			} else {
				Player staff = (Player) Bukkit.getOnlinePlayers();
				Player t = Bukkit.getPlayer(args[1]);
				if(staff.hasPermission("reports.recieve")) {
					staff.sendMessage(Utils.chat("&b&lPlayer " + p.getName() + " just reported " + t.getName() + " for " + args[0]));
					return true;
				} else {
					p.sendMessage(Utils.chat("&c&lWere sorry but there are no staff online. Please try again later."));
				}
			}
		}
		return false;
	}
}
