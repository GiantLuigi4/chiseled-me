package dev.necauqua.mods.cm.launch;

import dev.necauqua.mods.cm.ChiseledMe;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

// https://github.com/Meldexun/BlockOverlayFix/blob/51f576479db14e59480b92c832ed5d39ddb80519/src/main/java/meldexun/blockoverlayfix/asm/BlockOverlayFixPlugin.java
public class MixinTrigger implements IFMLLoadingPlugin {
	@Override
	public String[] getASMTransformerClass() {
		return new String[0];
	}
	
	@Override
	public String getModContainerClass() {
//		return "tfc.qolbackport.QOLBackport";
		return null;
	}
	
	@Nullable
	@Override
	public String getSetupClass() {
		return null;
	}
	
	@Override
	public void injectData(Map<String, Object> data) {
		MixinBootstrap.init();
		Mixins.addConfiguration("chiseled-me.hack.mixins.json");
		MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");
	}
	
	@Override
	public String getAccessTransformerClass() {
		return null;
	}
}
