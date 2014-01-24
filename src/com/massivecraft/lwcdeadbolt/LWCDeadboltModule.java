package com.massivecraft.lwcdeadbolt;

import com.griefcraft.lwc.LWC;
import com.griefcraft.scripting.JavaModule;
import com.griefcraft.scripting.event.LWCProtectionRegisterEvent;
import com.daemitus.deadbolt.Deadbolt;

public class LWCDeadboltModule extends JavaModule
{
	/**
	 * The bukkit plugin
	 */
	@SuppressWarnings("unused")
	private LWCDeadbolt plugin;
	
	/**
	 * The LWC object, set by load ()
	 */
	@SuppressWarnings("unused")
	private LWC lwc;

	public LWCDeadboltModule(LWCDeadbolt plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public void onRegisterProtection(LWCProtectionRegisterEvent event)
	{
		String owner = Deadbolt.getOwnerName(event.getBlock());
		if (owner == null) return;
		String player = event.getPlayer().getName();
		player = player.substring(0, Math.min(player.length(), 15));
		if (owner.equalsIgnoreCase(player)) return;
		event.setCancelled(true);
	}
	
}
