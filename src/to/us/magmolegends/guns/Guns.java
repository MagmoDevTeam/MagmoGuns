package to.us.magmolegends.guns;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Guns extends JavaPlugin implements Listener {

	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (!(e.getAction() == Action.RIGHT_CLICK_AIR)) return;
		
		if (!(e.getItem().getType() == Material.DIAMOND_HOE)) return;
		
		Fireball f = e.getPlayer().launchProjectile(Fireball.class);
		f.setIsIncendiary(false);
		f.setYield(0);
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Fireball) {
			Fireball f = (Fireball) e.getDamager();
			if (f.getShooter() instanceof Player) {
				Player shooter = (Player) f.getShooter();
				if (shooter.getItemInHand().getType() == Material.DIAMOND_HOE) {
					e.setDamage(10.0);
				}
			}
		}
	}
}