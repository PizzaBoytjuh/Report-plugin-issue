package nmzc.naaktm0lrat.reports;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import nmzc.naaktm0lrat.reports.commands.CommandReport;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println(ChatColor.GREEN + "Reports are now enabled!");
		new CommandReport(this);
	}
	
	@Override
	public void onDisable() {
		System.out.println(ChatColor.RED + "Reports are now disabled!");
	}
}
