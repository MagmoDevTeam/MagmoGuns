package to.us.magmolegends.guns;

public class guns {
	import org.bukkit.Bukkit;
	import org.bukkit.event.Listener;
	import org.bukkit.plugin.java.JavaPlugin;
	 
	public class Main extends JavaPlugin {
	 
	public void onEnable() {
	Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
	}
	}

