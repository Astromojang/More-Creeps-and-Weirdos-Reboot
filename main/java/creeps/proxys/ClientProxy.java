package creeps.proxys;

import creeps.render.CreepItemRender;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	
	
	
	
	public class ServerProxy extends CommonProxy {

	    @Override
	    public void preInit(FMLPreInitializationEvent e) {
	        super.preInit(e);
	    }

	    @Override
	    public void init(FMLInitializationEvent e) {
	        super.init(e);
	        CreepItemRender.registerItemRender();
	    }

	    @Override
	    public void postInit(FMLPostInitializationEvent e) {
	        super.postInit(e);
	    }
	
	
	}
}